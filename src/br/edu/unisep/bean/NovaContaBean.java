package br.edu.unisep.bean;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.dao.UsuarioDAO;
import br.edu.unisep.model.vo.ContaPagarReceberVO;
import br.edu.unisep.model.vo.ContaPagarReceberVO.TipoPagarReceber;
import br.edu.unisep.model.vo.ParcelaVO;
import br.edu.unisep.model.vo.ParcelaVO.situacaoParcela;
import br.edu.unisep.model.vo.UsuarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class NovaContaBean {

	private ContaPagarReceberVO conta = new ContaPagarReceberVO();

	private Integer quantidadeParcelas;

	private Date dataInicial;

	private Integer diaPagamento;

	private TipoPagarReceber[] tipoPagarReceber = TipoPagarReceber.values();

	@PostConstruct
	private void inicializar() {
		conta = new ContaPagarReceberVO();
		this.quantidadeParcelas = 1;
	}

	public String salvar() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		UsuarioVO usuario = daoUsuario.consultar(UsuarioVO.class, "e7aeba57-0305-4cc5-b18c-fab560c6bcfa");

		conta.setUsuario(usuario);

		MongoDAO<ContaPagarReceberVO> dao = new MongoDAO<ContaPagarReceberVO>();

		if (conta.getId() == null || conta.getId().equals("")) {
			conta.setId(null);
			dao.salvar(conta);
		} else {
			dao.alterar(conta);
		}

		MongoDAO<ParcelaVO> daoParcela = new MongoDAO<ParcelaVO>();
		for (ParcelaVO parcela : conta.getParcelas()) {
			parcela.setContaPagarReceber(conta);
			if (parcela.getId() == null || parcela.getId().equals("")) {
				parcela.setId(null);
				daoParcela.salvar(parcela);
			} else {
				daoParcela.alterar(parcela);
			}
		}
		
		return "listaContas?faces-redirect=true";
	}

	public void gerarParcelas() {
		Double valorParcelas = conta.getValor() / quantidadeParcelas;
		Calendar data = Calendar.getInstance();
		data.setTime(this.dataInicial);
		for (int i = 0; i < quantidadeParcelas; i++) {
			ParcelaVO parcela = new ParcelaVO();
			parcela.setNumero(i + 1);
			parcela.setSituacao(situacaoParcela.ABERTO.getIdentificador());
			parcela.setValor(valorParcelas);
			parcela.setDataVencimento(data.getTime());
			this.conta.getParcelas().add(parcela);
			data.add(Calendar.MONTH, 1);
		}
	}

	public ContaPagarReceberVO getConta() {
		return conta;
	}

	public void setConta(ContaPagarReceberVO conta) {
		this.conta = conta;
	}

	public TipoPagarReceber[] getTipoPagarReceber() {
		return tipoPagarReceber;
	}

	public void setTipoPagarReceber(TipoPagarReceber[] tipoPagarReceber) {
		this.tipoPagarReceber = tipoPagarReceber;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Integer getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(Integer diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

}

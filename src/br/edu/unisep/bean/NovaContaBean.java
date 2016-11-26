package br.edu.unisep.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.dao.UsuarioDAO;
import br.edu.unisep.model.vo.ContaPagarReceberVO;
import br.edu.unisep.model.vo.ContaPagarReceberVO.TipoPagarReceber;
import br.edu.unisep.model.vo.UsuarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class NovaContaBean {

	private ContaPagarReceberVO conta = new ContaPagarReceberVO();

	private TipoPagarReceber[] tipoPagarReceber = TipoPagarReceber.values();

	@PostConstruct
	private void inicializar() {
		conta = new ContaPagarReceberVO();
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

		return "listaContas?faces-redirect=true";
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
}

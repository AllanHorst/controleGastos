package br.edu.unisep.model.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import br.edu.unisep.model.vo.ContaPagarReceberVO.tipoPagarReceber;

@Entity
public class ParcelaVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private Double valor;

	private Date dataVencimento;

	private Integer numero;

	private String situacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Usar enum {@link situacaoParcela} para fazer operações,
	 * situacaoParcela.RECEBER.getIdentificador()
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * Usar enum {@link situacaoParcela} para fazer operações,
	 * situacaoParcela.RECEBER.getIdentificador()
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public enum situacaoParcela {
		ABERTO("ABERTO", "Aberto"), FECHADO("FECHADO", "Fechado");

		private String identificador;
		private String descricao;

		private situacaoParcela(String identificador, String descricao) {
			this.identificador = identificador;
			this.descricao = descricao;
		}

		public String getIdentificador() {
			return identificador;
		}

		public String getDescricao() {
			return descricao;
		}

	}

}
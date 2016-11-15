package br.edu.unisep.model.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ContaPagarReceberVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String descricao;

	private Double valor;

	private String tipo;
	
	@ManyToOne
	private List<ParcelaVO> parcelas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * Usar enum {@link tipoPagarReceber} para fazer operações,
	 * tipoPagarReceber.RECEBER.getIdentificador()
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Usar enum {@link tipoPagarReceber} para fazer operações,
	 * tipoPagarReceber.RECEBER.getIdentificador()
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ParcelaVO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaVO> parcelas) {
		this.parcelas = parcelas;
	}

	public enum tipoPagarReceber {
		PAGAR("PAGAR", "Pagar"), RECEBER("RECEBER", "Receber");

		private String identificador;
		private String descricao;

		private tipoPagarReceber(String identificador, String descricao) {
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
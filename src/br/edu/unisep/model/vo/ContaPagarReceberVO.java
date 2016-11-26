package br.edu.unisep.model.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private UsuarioVO usuario;

	@OneToMany(mappedBy = "contaPagarReceber", fetch = FetchType.EAGER)
	private List<ParcelaVO> parcelas = new ArrayList<ParcelaVO>();

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

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	/**
	 * Usar enum {@link TipoPagarReceber} para fazer operações,
	 * tipoPagarReceber.RECEBER.getIdentificador()
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Usar enum {@link TipoPagarReceber} para fazer operações,
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

	public enum TipoPagarReceber {
		PAGAR("PAGAR", "Pagar"), RECEBER("RECEBER", "Receber");

		private String identificador;
		private String descricao;

		private TipoPagarReceber(String identificador, String descricao) {
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
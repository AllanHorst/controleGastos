package br.edu.unisep.model.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caronas")
public class CaronaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carona")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioVO usuario;

	@OneToOne
	@JoinColumn(name = "id_cidadeorigem", referencedColumnName = "id_cidade")
	private CidadeVO cidadeOrigem;

	@OneToOne
	@JoinColumn(name = "id_cidadedestino", referencedColumnName = "id_cidade")
	private CidadeVO cidadeDestino;

	@Column(name = "dt_carona")
	private Date data;

	@Column(name = "nr_vagas")
	private Integer numeroVagas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public CidadeVO getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(CidadeVO cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public CidadeVO getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(CidadeVO cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(Integer numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

}

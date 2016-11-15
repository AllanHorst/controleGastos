package br.edu.unisep.model.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessoes")
public class SessaoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sessao")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_filme")
	private FilmeVO filme;

	@Column(name = "ds_horario")
	private String horario;

	@Column(name = "nr_lugares")
	private Integer numeroLugares;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FilmeVO getFilme() {
		return filme;
	}

	public void setFilme(FilmeVO filme) {
		this.filme = filme;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getNumeroLugares() {
		return numeroLugares;
	}

	public void setNumeroLugares(Integer numeroLugares) {
		this.numeroLugares = numeroLugares;
	}

}
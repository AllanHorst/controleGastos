package br.edu.unisep.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class SessaoVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@OneToOne
	private GrupoVO filme;

	private String horario;

	private Integer numeroLugares;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GrupoVO getFilme() {
		return filme;
	}

	public void setFilme(GrupoVO filme) {
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

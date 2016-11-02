package br.edu.unisep.model.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class PokemonVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pokemon")
	private Integer id;
	
	@Column(name="ds_pokemon")
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="id_tipo")
	private TipoPokemonVO tipo;
	
	@Column(name="tp_raridade")
	private Integer raridade;

	@Column(name="dt_descoberta")
	private Date dataDescoberta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPokemonVO getTipo() {
		return tipo;
	}

	public void setTipo(TipoPokemonVO tipo) {
		this.tipo = tipo;
	}

	public Integer getRaridade() {
		return raridade;
	}

	public void setRaridade(Integer raridade) {
		this.raridade = raridade;
	}
	
	public Date getDataDescoberta() {
		return dataDescoberta;
	}

	public void setDataDescoberta(Date dataDescoberta) {
		this.dataDescoberta = dataDescoberta;
	}
}
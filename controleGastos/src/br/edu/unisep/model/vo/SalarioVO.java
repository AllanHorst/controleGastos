package br.edu.unisep.model.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class SalarioVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private Double valor;

	private String descricao;

	private Date diaMesRecebimento;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDiaMesRecebimento() {
		return diaMesRecebimento;
	}

	public void setDiaMesRecebimento(Date diaMesRecebimento) {
		this.diaMesRecebimento = diaMesRecebimento;
	}
}
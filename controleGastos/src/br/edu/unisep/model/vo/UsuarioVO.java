package br.edu.unisep.model.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UsuarioVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String administrador;

	private String nome;

	private String email;

	private String senha;

	@ManyToOne
	private List<SalarioVO> listaSalarios;

	@ManyToOne
	private List<ContaPagarReceberVO> listaContasPagarReceber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<SalarioVO> getListaSalarios() {
		return listaSalarios;
	}

	public void setListaSalarios(List<SalarioVO> listaSalarios) {
		this.listaSalarios = listaSalarios;
	}

	public List<ContaPagarReceberVO> getListaContasPagarReceber() {
		return listaContasPagarReceber;
	}

	public void setListaContasPagarReceber(List<ContaPagarReceberVO> listaContasPagarReceber) {
		this.listaContasPagarReceber = listaContasPagarReceber;
	}

}
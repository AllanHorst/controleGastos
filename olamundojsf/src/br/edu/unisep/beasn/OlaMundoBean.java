package br.edu.unisep.beasn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class OlaMundoBean {
	private String mensagem;
	
	private String nome;
	
	public void exibirMensagem(ActionEvent event){
		
		this.mensagem = "Seja bem -vindo, "+ nome + "!";
		
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

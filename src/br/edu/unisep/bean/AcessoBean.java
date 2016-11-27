package br.edu.unisep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AcessoBean {

	private String login;
	
	private boolean admin;
	
	private boolean operador;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isOperador() {
		return operador;
	}

	public void setOperador(boolean operador) {
		this.operador = operador;
	}	
}

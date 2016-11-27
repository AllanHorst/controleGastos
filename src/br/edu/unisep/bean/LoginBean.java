package br.edu.unisep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class LoginBean {

	@ManagedProperty(value = "#{acessoBean}")
	private AcessoBean acessoBean;

	private String login;

	private String senha;

	public String executarLogin() {
		FacesContext context = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

		try {
			request.logout();
			request.login(login, senha);

			acessoBean.setLogin(login);

			if (request.isUserInRole("ADMIN")) {
				acessoBean.setAdmin(true);
			} else {
				acessoBean.setAdmin(false);
			}

			if (request.isUserInRole("OPERADOR")) {
				acessoBean.setOperador(true);
			} else {
				acessoBean.setOperador(false);
			}

			return "acesso/index.jsf?faces-redirect=true";
		} catch (ServletException e) {
			e.printStackTrace();
			return "login.jsf?faces-redirect=true";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public AcessoBean getAcessoBean() {
		return acessoBean;
	}

	public void setAcessoBean(AcessoBean acessoBean) {
		this.acessoBean = acessoBean;
	}
	
}

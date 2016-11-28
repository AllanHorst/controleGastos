package br.edu.unisep.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.vo.ContaVO;
import br.edu.unisep.model.vo.UsuarioVO;

@ManagedBean
@RequestScoped
public class ContaBean {
	
	private UsuarioVO usuario;
	
	@PostConstruct
	public void iniciar(){
		this.usuario = new UsuarioVO();
		this.usuario.setConta(new ContaVO());
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}

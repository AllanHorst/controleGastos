package br.edu.unisep.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.dao.UsuarioDAO;
import br.edu.unisep.model.vo.ContaVO;
import br.edu.unisep.model.vo.UsuarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class NovoUsuarioBean {

	private UsuarioVO usuario;

	@PostConstruct
	private void obterLista() {
		usuario = new UsuarioVO();
	}

	public String salvar() {
		ContaVO obj = new ContaVO();
		MongoDAO<ContaVO> daoConta = new MongoDAO<ContaVO>();
		daoConta.salvar(obj);

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);
		return "listaUsuarios?faces-redirect=true";
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}

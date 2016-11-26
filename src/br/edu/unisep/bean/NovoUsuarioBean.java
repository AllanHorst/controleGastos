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
	private void inicializar() {
		usuario = new UsuarioVO();
		System.out.println(usuario.getId());
	}

	public String salvar() {
		MongoDAO<ContaVO> daoConta = new MongoDAO<ContaVO>();
		ContaVO conta = daoConta.consultar(ContaVO.class, "d001824f-596e-4f4b-8252-f815cff6de5b");
		
		usuario.setConta(conta);

		UsuarioDAO dao = new UsuarioDAO();
		if (usuario.getId() == null || usuario.getId().equals("")) {
			usuario.setId(null);
			dao.salvar(usuario);
		} else {
			dao.alterar(usuario);
		}
		
		return "listaUsuarios?faces-redirect=true";
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}

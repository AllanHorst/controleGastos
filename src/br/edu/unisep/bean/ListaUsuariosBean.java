package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.dao.UsuarioDAO;
import br.edu.unisep.model.vo.UsuarioVO;

@ManagedBean
@RequestScoped
public class ListaUsuariosBean {

	private List<UsuarioVO> listaUsuarios;

	@PostConstruct
	private void obterLista() {
		UsuarioDAO dao = new UsuarioDAO();
		this.listaUsuarios = dao.obterListaPorConta("d001824f-596e-4f4b-8252-f815cff6de5b");
	}

	public void excluir(UsuarioVO vo) {
		UsuarioDAO dao = new UsuarioDAO();
		dao.excluir(vo);
		obterLista();
	}

	public List<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioVO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}

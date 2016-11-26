package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.dao.ContaPagarReceberDAO;
import br.edu.unisep.model.vo.ContaPagarReceberVO;

@ManagedBean
@RequestScoped
public class ListaContasBean {

	private List<ContaPagarReceberVO> listaContas;

	@PostConstruct
	private void obterLista() {
		ContaPagarReceberDAO dao = new ContaPagarReceberDAO();
		this.listaContas = dao.obterListaPorUsuario("e7aeba57-0305-4cc5-b18c-fab560c6bcfa");
	}

	public void excluir(ContaPagarReceberVO vo) {
		ContaPagarReceberDAO dao = new ContaPagarReceberDAO();
		dao.excluir(vo);
		obterLista();
	}

	public List<ContaPagarReceberVO> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<ContaPagarReceberVO> listaContas) {
		this.listaContas = listaContas;
	}

}

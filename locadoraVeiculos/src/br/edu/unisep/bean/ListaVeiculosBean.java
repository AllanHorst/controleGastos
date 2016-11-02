package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.dao.DAOGenerico;
import br.edu.unisep.model.vo.VeiculoVO;

@ManagedBean
@RequestScoped
public class ListaVeiculosBean {

	private List<VeiculoVO> listaVeiculos;

	public List<VeiculoVO> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<VeiculoVO> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	@PostConstruct
	public void obterLista() {
		DAOGenerico<VeiculoVO> dao = new DAOGenerico<VeiculoVO>();
		this.listaVeiculos = dao.listar(VeiculoVO.class);
	}

	public void excluirVeiculo(VeiculoVO vo) {
		DAOGenerico<VeiculoVO> dao = new DAOGenerico<VeiculoVO>();
		dao.excluir(vo);
	}
}

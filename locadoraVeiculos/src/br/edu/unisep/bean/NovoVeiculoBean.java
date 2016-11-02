package br.edu.unisep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.dao.DAOGenerico;
import br.edu.unisep.model.vo.VeiculoVO;

@ManagedBean
@RequestScoped
public class NovoVeiculoBean {

	private VeiculoVO veiculo = new VeiculoVO();

	public String salvar() {
		DAOGenerico<VeiculoVO> dao = new DAOGenerico<VeiculoVO>();
		dao.salvar(this.veiculo);
		return "index?faces-redirect=true";
	}

	public VeiculoVO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoVO veiculo) {
		this.veiculo = veiculo;
	}
}

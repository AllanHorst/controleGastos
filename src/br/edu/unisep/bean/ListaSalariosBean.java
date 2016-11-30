package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.vo.SalarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class ListaSalariosBean {
	
	private List<SalarioVO> listaSalarios;
	
	@PostConstruct
	public void listarSalarios(){
		MongoDAO<SalarioVO> dao = new MongoDAO<SalarioVO>();
		listaSalarios = dao.listar(SalarioVO.class);
	}
	
	public void excluir(SalarioVO salario){
		MongoDAO<SalarioVO> dao = new MongoDAO<SalarioVO>();
		dao.excluir(salario);
		
		listarSalarios();
	}
	
	public List<SalarioVO> getListaSalarios() {
		return listaSalarios;
	}

	public void setListaSalarios(List<SalarioVO> listaSalarios) {
		this.listaSalarios = listaSalarios;
	}	
}

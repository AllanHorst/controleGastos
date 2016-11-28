package br.edu.unisep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.vo.SalarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class NovaReceitaBean {
	
	private SalarioVO salario = new SalarioVO();
	
	public String Salvar(){
		MongoDAO<SalarioVO> dao = new MongoDAO<SalarioVO>();
		dao.salvar(salario);
		
		return "listaSalarios?faces-redirect=true";
	}

	public SalarioVO getSalario() {
		return salario;
	}

	public void setSalario(SalarioVO salario) {
		this.salario = salario;
	}
}

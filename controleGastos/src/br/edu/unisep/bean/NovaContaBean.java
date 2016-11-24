package br.edu.unisep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.model.vo.ContaPagarReceberVO;
import br.edu.unisep.mongodb.dao.MongoDAO;

@ManagedBean
@RequestScoped
public class NovaContaBean {
	
	private ContaPagarReceberVO conta = new ContaPagarReceberVO();
	
	public String salvar(){
		MongoDAO<ContaPagarReceberVO> dao = new MongoDAO<ContaPagarReceberVO>();
		dao.salvar(conta);
		
		return "index?faces-redirect=true";
	}

	public ContaPagarReceberVO getConta() {
		return conta;
	}

	public void setConta(ContaPagarReceberVO conta) {
		this.conta = conta;
	}
}

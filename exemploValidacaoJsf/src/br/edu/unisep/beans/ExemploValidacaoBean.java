package br.edu.unisep.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unisep.vo.ExemploVO;

@ManagedBean
@RequestScoped
public class ExemploValidacaoBean {

	private ExemploVO exemplo;

	public ExemploVO getExemplo() {
		return exemplo;
	}

	public void setExemplo(ExemploVO exemplo) {
		this.exemplo = exemplo;
	}

}

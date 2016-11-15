package br.edu.unisep.model.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ContaVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private List<UsuarioVO> usuarios;

	public List<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}
}
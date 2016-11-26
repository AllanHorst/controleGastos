package br.edu.unisep.model.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ContaVO {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
	private List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

	public List<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}
}
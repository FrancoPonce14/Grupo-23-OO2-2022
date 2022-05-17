package com.grupo23.Grupo230022022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name="nombre", unique=true, nullable=false, length=50)
	private String nombre;
	
	@Column(name="habilitado", nullable=false)
	private boolean habilitado;
	
	public Perfil() {}

	public Perfil(int idPerfil, String nombre, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.idPerfil = idPerfil;
		this.habilitado = habilitado;
	}


	public int getIdPerfil() {
		return idPerfil;
	}

	protected void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
}
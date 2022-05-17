package com.grupo23.Grupo230022022.models;



public class PerfilModel {
	
	private int idPerfil;
	private String nombre;
	private boolean habilitado;
	
	public PerfilModel() {}

	public PerfilModel(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public PerfilModel(int idPerfil, String nombre, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.idPerfil = idPerfil;
		this.habilitado = habilitado;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
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

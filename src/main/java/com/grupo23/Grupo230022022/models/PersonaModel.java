package com.grupo23.Grupo230022022.models;

import javax.validation.constraints.NotNull;

public class PersonaModel {
	
	private int idPersona;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private long documento;
	
	public PersonaModel() {}

	public PersonaModel(int idPersona, String nombre, String apellido, long documento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDni(long documento) {
		this.documento = documento;
	}	
}

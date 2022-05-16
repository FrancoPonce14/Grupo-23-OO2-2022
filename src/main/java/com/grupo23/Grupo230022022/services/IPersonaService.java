package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Persona;
import com.grupo23.Grupo230022022.models.PersonaModel;



public interface IPersonaService {
	
	public List<Persona> getAll();
	public Persona insertOrUpdate(Persona persona);
	public PersonaModel findById(int idPersona);
	public PersonaModel findByNombre(String nombre);
	public PersonaModel findByApellido(String apellido);
	public Persona findByDocumento(long documento);
	public boolean remove(int idPersona);

}

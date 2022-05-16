package com.grupo23.Grupo230022022.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo23.Grupo230022022.entities.Persona;



@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>{
	
	public abstract Persona findByIdPersona(int idPerfil);
	public abstract Persona findByNombre(String nombre);
	public abstract Persona findByApellido(String apellido);
	public abstract Persona findByDocumento(long documento);
	
}

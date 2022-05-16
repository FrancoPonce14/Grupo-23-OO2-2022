package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.converters.PersonaConverter;
import com.grupo23.Grupo230022022.entities.Persona;
import com.grupo23.Grupo230022022.models.PersonaModel;
import com.grupo23.Grupo230022022.repositories.IPersonaRepository;
import com.grupo23.Grupo230022022.services.IPersonaService;


@Service("personaService")
public class PersonaService implements IPersonaService{
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	@Override
	public Persona insertOrUpdate(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public PersonaModel findById(int idPersona) {
		Persona persona = personaRepository.findByIdPersona(idPersona);
		PersonaModel personaModel = null;
		if(persona != null) 
			personaModel = personaConverter.entityToModel(persona);
		return personaModel;
	}

	@Override
	public PersonaModel findByNombre(String nombre) {
		Persona persona = personaRepository.findByNombre(nombre);
		PersonaModel personaModel = null;
		if(persona != null) 
			personaModel = personaConverter.entityToModel(persona);
		return personaModel;
	}

	@Override
	public PersonaModel findByApellido(String apellido) {
		Persona persona = personaRepository.findByApellido(apellido);
		PersonaModel personaModel = null;
		if(persona != null) 
			personaModel = personaConverter.entityToModel(persona);
		return personaModel;
	}

	@Override
	public Persona findByDocumento(long documento) {
		return personaRepository.findByDocumento(documento);
	}

	@Override
	public boolean remove(int idPersona) {
		try {
			personaRepository.deleteById(idPersona);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}

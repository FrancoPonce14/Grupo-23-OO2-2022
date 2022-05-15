package com.grupo23.Grupo230022022.converters;

import org.springframework.stereotype.Component;

import com.grupo23.Grupo230022022.entities.Persona;
import com.grupo23.Grupo230022022.models.PersonaModel;



@Component("personaConverter")
public class PersonaConverter {
	
	public PersonaModel entityToModel(Persona persona) {
		PersonaModel personaModel = null;
		if(persona != null)
			personaModel = new PersonaModel(persona.getIdPersona(), persona.getNombre(), persona.getApellido(), persona.getDocumento());
		return personaModel;
	}
	
	public Persona modelToEntity(PersonaModel personaModel) {
		Persona persona = null;
		if(personaModel != null)
			persona = new Persona(personaModel.getIdPersona(), personaModel.getNombre(), personaModel.getApellido(), personaModel.getDocumento());
		return persona;
	}
	

}

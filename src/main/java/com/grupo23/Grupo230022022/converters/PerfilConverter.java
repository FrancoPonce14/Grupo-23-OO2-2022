package com.grupo23.Grupo230022022.converters;

import org.springframework.stereotype.Component;

import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.models.PerfilModel;



@Component("perfilConverter")
public class PerfilConverter {
	
	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(), perfil.getNombre(), perfil.isHabilitado());
	}

	public Perfil modelToEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(),perfilModel.getNombre(),perfilModel.isHabilitado());
	}
	


}

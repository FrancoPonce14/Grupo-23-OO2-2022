package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.models.PerfilModel;


public interface IPerfilService {

	public List<Perfil> getAll();
	public PerfilModel insertOrUpdate(PerfilModel PerfilModel);
	public boolean remove(int id);
	PerfilModel findById(int id);
	PerfilModel findByNombrePerfil(String nombrePerfil);
	public abstract List<Perfil> getPerfilesHabilitados();
}

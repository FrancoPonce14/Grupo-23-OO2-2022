package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.converters.PerfilConverter;
import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.models.PerfilModel;
import com.grupo23.Grupo230022022.repositories.IPerfilRepository;
import com.grupo23.Grupo230022022.services.IPerfilService;



@Service("perfilService")
public class PerfilService implements IPerfilService{
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;	
	
	@Override
	public List<Perfil> getAll() {
		return perfilRepository.findAll();
	}

	@Override
	public PerfilModel findById(int id) {
		return perfilConverter.entityToModel(perfilRepository.findByIdPerfil(id));
	}

	@Override
	public PerfilModel findByNombrePerfil(String nombrePerfil) {
		return perfilConverter.entityToModel(perfilRepository.findByNombre(nombrePerfil));
	}
	@Override
	public PerfilModel insertOrUpdate(PerfilModel PerfilModel) {
		Perfil Perfil = perfilRepository.save(perfilConverter.modelToEntity(PerfilModel));
		return perfilConverter.entityToModel(Perfil);
	}

	@Override
	public boolean remove(int id) {
		try {
			perfilRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Perfil> getPerfilesHabilitados() {
		return perfilRepository.getPerfilesHabilitados();
	}
}

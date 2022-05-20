package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.models.PerfilModel;
import com.grupo23.Grupo230022022.repositories.IPerfilRepository;
import com.grupo23.Grupo230022022.services.IPerfilService;



@Service("perfilService")
public class PerfilService implements IPerfilService{
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	@Override
	public PerfilModel findById(int id) {
		return modelMapper.map(perfilRepository.findById(id), PerfilModel.class);
	}

	@Override
	public PerfilModel findByNombrePerfil(String nombrePerfil) {
		return modelMapper.map(perfilRepository.findByNombre(nombrePerfil), PerfilModel.class);
	}
	@Override
	public PerfilModel insertOrUpdate(PerfilModel PerfilModel) {
		Perfil perfil = perfilRepository.save(modelMapper.map(PerfilModel, Perfil.class));
		return modelMapper.map(perfil, PerfilModel.class);
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

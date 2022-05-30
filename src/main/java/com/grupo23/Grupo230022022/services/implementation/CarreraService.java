package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Carrera;
import com.grupo23.Grupo230022022.repositories.ICarreraRepository;
import com.grupo23.Grupo230022022.services.ICarreraService;


@Service("carreraService")
public class CarreraService implements ICarreraService {

	@Autowired
	//@Qualifier("carreraRepository")
	private ICarreraRepository carreraRepository;
	
	@Override
	public List<Carrera> getAll() {
		return carreraRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Carrera carrera) {
		try {
			carreraRepository.save(carrera);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Carrera findById(int id) {
		return carreraRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			carreraRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}

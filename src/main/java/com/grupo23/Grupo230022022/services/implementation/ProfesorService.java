package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Profesor;
import com.grupo23.Grupo230022022.repositories.IProfesorRepository;
import com.grupo23.Grupo230022022.services.IProfesorService;



@Service("profesorService")
public class ProfesorService implements IProfesorService{

	@Autowired
	//@Qualifier("profesorRepository")
	private IProfesorRepository profesorRepository;

	@Override
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Profesor profesor) {
		try {
			profesorRepository.save(profesor);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Profesor findById(int id) {
		return profesorRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			profesorRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}

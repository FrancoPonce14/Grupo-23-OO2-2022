package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Materia;
import com.grupo23.Grupo230022022.repositories.IMateriaRepository;
import com.grupo23.Grupo230022022.services.IMateriaService;



@Service("materiaService")
public class MateriaService implements IMateriaService {
	
	@Autowired
	//@Qualifier("materiaRepository")
	private IMateriaRepository materiaRepository;
	
	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Materia materia) {
		try {
			materiaRepository.save(materia);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Materia findById(int id) {
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			materiaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}

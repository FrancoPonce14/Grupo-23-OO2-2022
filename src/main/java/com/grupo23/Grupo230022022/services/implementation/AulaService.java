package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Aula;
import com.grupo23.Grupo230022022.repositories.IAulaRepository;
import com.grupo23.Grupo230022022.services.IAulaService;



@Service("aulaService")
public class AulaService implements IAulaService{

	@Autowired
	//@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;
	
	@Override
	public List<Aula> getAll(){
		return aulaRepository.findAll();
	}
	
	@Override
	public boolean insertOrUpdate(Aula aula) {
		try {
			aulaRepository.save(aula);
			return true;
		}catch (Exception he){
			return false;
		}
	}

	@Override
	public Aula findById(int id) {
		return aulaRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			aulaRepository.deleteById(id);
			return true;
		}catch(Exception he) {
			return false;
		}
	}

}

package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Edificio;
import com.grupo23.Grupo230022022.repositories.IEdificioRepository;
import com.grupo23.Grupo230022022.services.IEdificioService;


@Service("edificioService")
public class EdificioService implements IEdificioService{

	@Autowired
	//@Qualifier("espacioRepository")
	private IEdificioRepository edificioRepository;
	
	@Override
	public List<Edificio> getAll() {
		return edificioRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Edificio edificio) {
		try {
			edificioRepository.save(edificio);
			return true;
		}catch (Exception he){
			return false;
		}
	}

	@Override
	public Edificio findById(int id) {
		return edificioRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			edificioRepository.deleteById(id);
			return true;
		}catch(Exception he) {
			return false;
		}
	}
}

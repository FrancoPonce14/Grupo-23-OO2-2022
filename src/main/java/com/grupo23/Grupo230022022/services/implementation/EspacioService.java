package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Espacio;
import com.grupo23.Grupo230022022.repositories.IEspacioRepository;
import com.grupo23.Grupo230022022.services.IEspacioService;



@Service("espacioService")
public class EspacioService implements IEspacioService{
	
	@Autowired
	//@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Override
	public List<Espacio> getAll() {
		return espacioRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Espacio espacio) {
		try {
			espacioRepository.save(espacio);
			return true;
		}catch (Exception he){
			return false;
		}
	}

	@Override
	public Espacio findById(int id) {
		return espacioRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			espacioRepository.deleteById(id);
			return true;
		}catch(Exception he) {
			return false;
		}
	}



}

package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.Departamento;
import com.grupo23.Grupo230022022.repositories.IDepartamentoRepository;
import com.grupo23.Grupo230022022.services.IDepartamentoService;


@Service("departamentoService")
public class DepartamentoService implements IDepartamentoService{

	@Autowired
	//@Qualifier("departamentoRepository")
	private IDepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> getAll() {
		return departamentoRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Departamento departamento) {
		try {
			departamentoRepository.save(departamento);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Departamento findById(int id) {
		return departamentoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			departamentoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}

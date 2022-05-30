package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Departamento;



public interface IDepartamentoService {

	public List<Departamento> getAll();
	public boolean insertOrUpdate(Departamento departamento);
	public Departamento findById(int id);
	public boolean remove(int id);
}

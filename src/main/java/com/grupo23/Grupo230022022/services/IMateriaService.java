package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Materia;



public interface IMateriaService {

	public List<Materia> getAll();
	public boolean insertOrUpdate(Materia materia);
	public Materia findById(int id);
	public boolean remove(int id);
}

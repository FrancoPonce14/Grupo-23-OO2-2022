package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Profesor;



public interface IProfesorService {

	public List<Profesor> getAll();
	public boolean insertOrUpdate(Profesor profesor);
	public Profesor findById(int id);
	public boolean remove(int id);
}

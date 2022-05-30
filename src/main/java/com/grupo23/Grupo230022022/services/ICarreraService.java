package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Carrera;



public interface ICarreraService {

	public List<Carrera> getAll();
	public boolean insertOrUpdate(Carrera carrera);
	public Carrera findById(int id);
	public boolean remove(int id);
}

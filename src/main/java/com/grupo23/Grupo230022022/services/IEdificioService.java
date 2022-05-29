package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Espacio;

public interface IEdificioService {
	
	public List<Espacio> getAll();
	public boolean insertOrUpdate(Espacio edificio);
	public Espacio findById(int id);
	public boolean remove(int id);
	public Espacio traerEdificioConAulas(int idEdificio);
}

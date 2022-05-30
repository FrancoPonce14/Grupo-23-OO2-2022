package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Edificio;

public interface IEdificioService {
	
	public List<Edificio> getAll();
	public boolean insertOrUpdate(Edificio edificio);
	public Edificio findById(int id);
	public boolean remove(int id);
	public Edificio traerEdificioConAulas(int idEdificio);
}

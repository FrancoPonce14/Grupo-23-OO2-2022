package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Espacio;


public interface IEspacioService {

	public List<Espacio> getAll();
	public boolean insertOrUpdate(Espacio espacio);
	public Espacio findById(int id);
	public boolean remove(int id);
}

package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Aula;



public interface IAulaService {
	
	public List<Aula> getAll();
	public boolean insertOrUpdate(Aula aula);
	public Aula findById(int id);
	public boolean remove(int id);

}

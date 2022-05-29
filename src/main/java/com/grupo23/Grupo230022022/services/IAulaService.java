package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Aula;
import com.grupo23.Grupo230022022.entities.Laboratorio;
import com.grupo23.Grupo230022022.entities.Tradicional;



public interface IAulaService {
	
	public List<Aula> getAll();
	public boolean insertOrUpdate(Aula aula);
	public Aula findById(int id);
	public boolean remove(int id);
	public List<Tradicional> getAllTradicional();
	public List<Laboratorio> getAllLaboratorio();
	public List<Tradicional> getAllTradicionalID(int id);
	public List<Laboratorio> getAllLaboratorioID(int id);

}

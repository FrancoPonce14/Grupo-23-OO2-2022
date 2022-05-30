package com.grupo23.Grupo230022022.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo23.Grupo230022022.entities.Edificio;


public interface IEdificioRepository extends JpaRepository<Edificio, Integer>{
	
	@Query(value = "SELECT * FROM edificio e INNER JOIN aula a ON e.id = a.edificio_id "+"where a.edificio_id=:idEdificio",nativeQuery=true)
	public abstract Edificio traerEdificioConAulas(int idEdificio);


}

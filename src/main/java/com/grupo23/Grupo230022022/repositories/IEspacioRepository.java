package com.grupo23.Grupo230022022.repositories;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo23.Grupo230022022.entities.Aula;
import com.grupo23.Grupo230022022.entities.Espacio;


public interface IEspacioRepository extends JpaRepository<Espacio, Integer>{
	
	@Query(value="select from espacio", nativeQuery=true)
	public abstract Espacio traer(LocalDate fecha, char turno, @Param("aula") Aula aula); 

	
}

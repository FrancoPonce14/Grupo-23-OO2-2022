package com.grupo23.Grupo230022022.repositories;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo23.Grupo230022022.entities.Aula;
import com.grupo23.Grupo230022022.entities.Espacio;


public interface IEspacioRepository extends JpaRepository<Espacio, Integer>{
	
	//SELECT * FROM ESPACIO INNER JOIN AULA WHERE ESPACIO.FECHA='2022-05-28' AND ESPACIO.TURNO='T' AND AULA.ID=1;
	@Query(value = "SELECT * FROM ESPACIO INNER JOIN AULA WHERE ESPACIO.FECHA=:fecha and ESPACIO.TURNO=:turno and AULA.ID=:#{#aula.id}", nativeQuery=true)
	public abstract Espacio traer(LocalDate fecha, char turno, @Param("aula") Aula aula); 

	
}

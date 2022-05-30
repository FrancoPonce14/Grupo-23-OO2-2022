package com.grupo23.Grupo230022022.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo23.Grupo230022022.entities.Aula;
import com.grupo23.Grupo230022022.entities.Laboratorio;
import com.grupo23.Grupo230022022.entities.Tradicional;




public interface IAulaRepository extends JpaRepository<Aula, Integer> {
	
	@Query(value = "SELECT * FROM aula INNER JOIN laboratorio ON aula.id = laboratorio.id_laboratorio",nativeQuery=true)
	public abstract List<Laboratorio> getLaboratorio();
	@Query(value = "SELECT * FROM aula INNER JOIN tradicional ON aula.id = tradicional.id_tradicional",nativeQuery=true)
	public abstract List<Tradicional> getTradicional();
	
	@Query(value = "SELECT * FROM aula INNER JOIN laboratorio ON aula.id = laboratorio.id_laboratorio"+"where laboratorio.id_laboratorio=:idLaboratorio",nativeQuery=true)
	public abstract List<Laboratorio> getAllLaboratorioID(int idLaboratorio);
	@Query(value = "SELECT * FROM aula INNER JOIN tradicional ON aula.id = tradicional.id_tradicional"+"where tradicional.id_tradicional=:idTradicional",nativeQuery=true)
	public abstract List<Tradicional> getAllTradicionalID(int idTradicional);
	

}

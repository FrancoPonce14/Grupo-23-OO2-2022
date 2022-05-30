package com.grupo23.Grupo230022022.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id", name = "idCurso")
@Table(name="curso")
@Getter @Setter @NoArgsConstructor
public class Curso extends NotaPedido{
	
	@Column(name="codCurso", nullable=false)
	private String codCurso;
	
	@Column(name = "modalidad", nullable=false)
	private String modalidad;

}

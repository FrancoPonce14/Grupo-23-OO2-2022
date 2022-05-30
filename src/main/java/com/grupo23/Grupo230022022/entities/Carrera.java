package com.grupo23.Grupo230022022.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="carrera")
@Data @NoArgsConstructor
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="carrera", nullable=false)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	
}

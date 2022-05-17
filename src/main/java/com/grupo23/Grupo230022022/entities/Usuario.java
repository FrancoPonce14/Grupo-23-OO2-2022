package com.grupo23.Grupo230022022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellido", nullable=false)
	private String apellido;
	
	@Column(name="tipoDocumento", nullable=false, length=5)
	private String tipoDocumento;
	
	@Column(name="documento", unique=true, nullable=false, length=45)
	private long documento;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="nombreUsuario", unique=true, nullable=false, length=45)
	private String nombreUsuario;
	
	@Column(name="clave", nullable=false, length=60)
	private String clave;
	
	@Column(name="habilitado")
	private boolean habilitado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_perfil", nullable=false)
	private Perfil perfil;

	
	public Usuario() {}

	public Usuario(int idUsuario, String nombre, String apellido, String tipoDocumento, long documento, String email,
			String nombreUsuario, String clave, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}

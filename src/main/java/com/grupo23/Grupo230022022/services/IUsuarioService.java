package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.Usuario;
import com.grupo23.Grupo230022022.models.UsuarioModel;


public interface IUsuarioService {

	public List<Usuario> findAll();
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	public boolean remove(int id);
	UsuarioModel findById(int id);
	UsuarioModel findByNombreUsuario(String nombreUsuario);
	public List<Usuario> findByIdPerfil(int idPerfil);
}

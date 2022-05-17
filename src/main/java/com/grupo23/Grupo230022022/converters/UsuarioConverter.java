package com.grupo23.Grupo230022022.converters;

import org.springframework.stereotype.Component;

import com.grupo23.Grupo230022022.entities.Usuario;
import com.grupo23.Grupo230022022.models.UsuarioModel;



@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(), usuario.getNombre(),usuario.getApellido(), usuario.getTipoDoc(),
				usuario.getDocumento(), usuario.getEmail(), usuario.getNombreUsuario(), usuario.getClave(),usuario.getPerfil());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getIdUsuario(),usuarioModel.getNombre(),usuarioModel.getApellido(),
				usuarioModel.getTipoDoc(),usuarioModel.getDocumento(),usuarioModel.getEmail(),usuarioModel.getNombreUsuario(),
				usuarioModel.getClave(),usuarioModel.getPerfil());
	}
	

}

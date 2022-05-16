package com.grupo23.Grupo230022022.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.converters.UsuarioConverter;
import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.entities.Usuario;
import com.grupo23.Grupo230022022.models.UsuarioModel;
import com.grupo23.Grupo230022022.repositories.IUsuarioRepository;
import com.grupo23.Grupo230022022.services.IUsuarioService;


@Service("usuarioService")
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioModel findById(int id) {
		return usuarioConverter.entityToModel(usuarioRepository.findByIdUsuario(id));
	}

	@Override
	public UsuarioModel findByNombreUsuario(String nombreUsuario) {
		return usuarioConverter.entityToModel(usuarioRepository.findByNombreUsuario(nombreUsuario));
	}
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		String clave = bCryptPasswordEncoder.encode(usuarioModel.getClave());
		usuarioModel.setClave(clave);
		Usuario usuario = usuarioConverter.modelToEntity(usuarioModel);
		usuario.setEnabled(true);
		usuarioRepository.save(usuario);
		return usuarioConverter.entityToModel(usuario);
	}

	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Usuario> findByIdPerfil(int idPerfil) {
		List<Usuario> lista = usuarioRepository.findByIdPerfil(idPerfil);
		return lista;
	}

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);	
		User u = buildUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
		return u;
	}
	
	private User buildUser(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getNombreUsuario(), usuario.getClave(), usuario.isEnabled(),
						true, true, true,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombre()));

		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}

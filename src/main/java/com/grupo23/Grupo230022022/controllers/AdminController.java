package com.grupo23.Grupo230022022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.grupo23.Grupo230022022.helpers.ViewRouteHelper;
import com.grupo23.Grupo230022022.models.PerfilModel;
import com.grupo23.Grupo230022022.models.UsuarioModel;
import com.grupo23.Grupo230022022.services.IPerfilService;
import com.grupo23.Grupo230022022.services.IUsuarioService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	@GetMapping("/index")
	public ModelAndView indexAdmin(@RequestParam(name="nombreUsuario",required=false) String nombreUsuario) {
		ModelAndView mVA = new ModelAndView(ViewRouteHelper.INDEX_ADMIN);
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 nombreUsuario = auth.getName();
		 mVA.addObject("nombreUsuario", nombreUsuario);
		return mVA;
	}	
	@GetMapping("/usuarios")
	public ModelAndView verUsuarios_Admin() {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nombreUsuario = auth.getName();
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VER_USUARIOS);
		mAV.addObject("lstUsuarios", usuarioService.findAll());
		mAV.addObject("usuario", new UsuarioModel());
		mAV.addObject("usuarioActual",usuarioService.findByNombreUsuario(nombreUsuario));
		
		return mAV;
	}
	@GetMapping("/perfiles")
	public ModelAndView perfilIndex() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VER_PERFILES);
		mAV.addObject("lstPerfiles", perfilService.findAll());
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}

}

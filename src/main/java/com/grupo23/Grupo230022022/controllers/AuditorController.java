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
@RequestMapping("/auditor")
public class AuditorController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	@GetMapping("/index")
	public ModelAndView indexAuditor(@RequestParam(name="nombreUsuario",required=false) String nombreUsuario) {
		ModelAndView mVA = new ModelAndView(ViewRouteHelper.INDEX_AUDITOR);
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		nombreUsuario = auth.getName();
		mVA.addObject("nombreUsuario", nombreUsuario);
		return mVA;
	}
	
	//Si no entendi mal, la vista de los profesores solo tiene que ser de visualización entonces podriamos usar esta 
	//y que el administrado haga los cosas necesarias 
	@GetMapping("/usuarios")
	public ModelAndView verUsuarios_Auditor() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_USUARIOS);
		mAV.addObject("lstUsuarios", usuarioService.findAll());
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	@GetMapping("/perfiles")
	public ModelAndView verPerfiles_Auditor() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_PERFILES);
		mAV.addObject("lstPerfiles", perfilService.getAll());
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}


}

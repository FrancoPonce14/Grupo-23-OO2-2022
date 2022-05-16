package com.grupo23.Grupo230022022.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grupo23.Grupo230022022.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@GetMapping("/")
	public ModelAndView index(@RequestParam(name="perfil",required=false) String perfil) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
		org.springframework.security.core.Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		perfil = (auth.getAuthorities().toString());
		perfil = perfil.replace("[", ""); 
		perfil = perfil.replace("]", ""); // para poder usar el perfil le saco las [ ] que tiene al inicio y final ya que es una coleccion 
		mAV.addObject("perfil", perfil);
		return mAV;
	}
	
	
}

package com.grupo23.Grupo230022022.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grupo23.Grupo230022022.helpers.ViewRouteHelper;



@Controller
@RequestMapping("/auditor")
public class AuditorController {
	
	@GetMapping("/index")
	public ModelAndView indexAuditor(@RequestParam(name="nombreUsuario",required=false) String nombreUsuario) {
		ModelAndView mVA = new ModelAndView(ViewRouteHelper.INDEX_AUDITOR);
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		nombreUsuario = auth.getName();
		mVA.addObject("nombreUsuario", nombreUsuario);
		return mVA;
	}

}

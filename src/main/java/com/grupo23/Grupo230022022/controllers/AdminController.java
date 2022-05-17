package com.grupo23.Grupo230022022.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo23.Grupo230022022.converters.PerfilConverter;
import com.grupo23.Grupo230022022.converters.UsuarioConverter;
import com.grupo23.Grupo230022022.entities.Perfil;
import com.grupo23.Grupo230022022.entities.Usuario;
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
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
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
	@GetMapping("/usuario/{id}")
	public ModelAndView get_id(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDITAR_USUARIO);
		mAV.addObject("usuario", usuarioService.findById(id));
		mAV.addObject("lstPerfiles", perfilService.getPerfilesHabilitados());
		return mAV;
	}
	//MUESTRO EL FROM PARA CREAR USUARIO
	@GetMapping("/usuario/nuevo")
	public ModelAndView addUsuario_admin() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.AGREGAR_USUARIO);
		mAV.addObject("usuario", new UsuarioModel());
		mAV.addObject("lstPerfiles", perfilService.getPerfilesHabilitados());
		return mAV;
	}
	//ABM USUARIOS
	@PostMapping("/usuario/crear")
	public RedirectView createUsuario_admin(@ModelAttribute("usuario") UsuarioModel usuarioModel, RedirectAttributes redirectAttributes) {

		PerfilModel model = perfilService.findById(usuarioModel.getIdPerfil());
		Perfil perfil = perfilConverter.modelToEntity(model);
		usuarioModel.setPerfil(perfil);
		boolean salioError = false;
		
		List<Usuario> lstUsuarios = usuarioService.findAll();
		Usuario usuario = usuarioConverter.modelToEntity(usuarioModel);
		for(Usuario u : lstUsuarios) {
			if(u.getDocumento() == usuario.getDocumento() && u.getIdUsuario() != usuario.getIdUsuario()) {
				     salioError = true;
			}
		}
		if(salioError) {
			redirectAttributes.addFlashAttribute("error", true);
		}else {
		usuarioService.insertOrUpdate(usuarioModel);
		redirectAttributes.addFlashAttribute("sussceful", true);
		}
		return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
	}	
	@PostMapping("/usuario/editar")
	public RedirectView editarUsuario_admin(@ModelAttribute("usuario") UsuarioModel usuarioModel,
			RedirectAttributes redirectAttributes) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UsuarioModel user = usuarioService.findByNombreUsuario(auth.getName());
		List<Usuario> lstUsuarios = usuarioService.findAll();
		Usuario usuario = usuarioConverter.modelToEntity(usuarioModel);

		if (!user.equals(usuarioModel)) {
			PerfilModel model = perfilService.findById(usuarioModel.getIdPerfil());
			Perfil perfil = perfilConverter.modelToEntity(model);
			usuarioModel.setPerfil(perfil);

			for (Usuario u : lstUsuarios) {
				if (u.getDocumento() == usuario.getDocumento() && u.getIdUsuario() != usuario.getIdUsuario()) {
					redirectAttributes.addFlashAttribute("error", true);
				} else {
					usuarioService.insertOrUpdate(usuarioModel);
					redirectAttributes.addFlashAttribute("sussceful", true);
				}
			}

		}

		return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
	}
	
	@GetMapping("/usuario/eliminar/{id}")
	public RedirectView eliminarUsuario_admin(@PathVariable("id") int idUsuario, RedirectAttributes redirectAttributes) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioModel usuario = usuarioService.findByNombreUsuario(auth.getName());
		if(!(usuario.getIdUsuario() == idUsuario)) {
			usuarioService.remove(idUsuario);
			redirectAttributes.addFlashAttribute("removed", true);
		}
		return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
	}

}

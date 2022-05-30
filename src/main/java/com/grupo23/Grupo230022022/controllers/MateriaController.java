package com.grupo23.Grupo230022022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo23.Grupo230022022.entities.Materia;
import com.grupo23.Grupo230022022.helpers.ViewRouteHelper;
import com.grupo23.Grupo230022022.services.ICarreraService;
import com.grupo23.Grupo230022022.services.IMateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	@Qualifier("materiaService")
	private IMateriaService materiaService;
	
	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService;
	
	@GetMapping("/admin/index") 
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_MATERIA);
		mAV.addObject("lstMaterias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		return mAV;
	}
	@GetMapping("/nuevo")  //MENU AGREGAR
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MATERIA_NUEVO);
		mAV.addObject("lstMaterias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		return mAV;
	}
	@GetMapping("/nuevo/agregar") //GET CREAR
	public ModelAndView newCreate() { 
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MATERIA_AGREGAR);
		mAV.addObject("lstMaterias", materiaService.getAll());
		mAV.addObject("lstCarreras", carreraService.getAll());
		mAV.addObject("materia", new Materia());
		return mAV;
	}
	@PostMapping("/crear")
	public RedirectView create_dep(@ModelAttribute("materia") Materia materia, RedirectAttributes redirectAttributes) {
		materiaService.insertOrUpdate(materia);
		redirectAttributes.addFlashAttribute("materia_agreagdo", true);
		return new RedirectView(ViewRouteHelper.MATERIA_REDIRECT);
	}
	@GetMapping("/index/editar") // MUESTRA LA INDEX NORMAL CON LOS OBJETOS EDITABLES
	public ModelAndView editar(@ModelAttribute("materia") Materia materia) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MATERIA_EDITAR);
		mAV.addObject("lstMaterias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		return mAV;
	}
	@GetMapping("/editar/{id}") // GET DE EDITAR
	public ModelAndView editar_e(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MATERIA_EDIT);
		mAV.addObject("materia", materiaService.findById(id));
		mAV.addObject("lstCarreras", carreraService.getAll());
		return mAV;
	} 
	@PostMapping("/edit") //POST DE EDITAR
	public RedirectView edit_suss(@ModelAttribute("materia") Materia materia, RedirectAttributes redirectAttributes) {
		materiaService.insertOrUpdate(materia);
		redirectAttributes.addFlashAttribute("materia_editado", true);
		return new RedirectView(ViewRouteHelper.MATERIA_REDIRECT);
	}
	@GetMapping("/eliminar")
	public ModelAndView eliminar_e(@ModelAttribute("materia") Materia materia){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MATERIA_ELIMINAR);
		mAV.addObject("lstMaterias", materiaService.getAll());
		mAV.addObject("materia", new Materia());
		return mAV;
	}
	@GetMapping("/eliminar/{id}") //ELIMINA CON GET, NO ME FUNCIONA CON POST
	public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		materiaService.remove(id);
		redirectAttributes.addFlashAttribute("materia_borrado", true);
		return new RedirectView(ViewRouteHelper.MATERIA_REDIRECT);
	}
}

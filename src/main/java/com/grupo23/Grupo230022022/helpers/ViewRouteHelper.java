package com.grupo23.Grupo230022022.helpers;

public class ViewRouteHelper {

	public final static String DASHBOARD = "/home/dashboard";
	// INICIO/CIERRE SESIÓN + INDEXS ADMIN - AUDITOR
	public final static String LOGIN = "/session/login";
	public final static String LOGOUT = "/session/logout";
	public final static String INDEX = "/home/index";
	public final static String PERFIL_AUDITOR = "/auditor/index";
	public final static String INDEX_AUDITOR = "/perfiles/perfil_auditor/indexAuditor";
	public final static String PERFIL_ADMIN = "/admin/index";
	public final static String INDEX_ADMIN = "/perfiles/perfil_admin/indexAdmin";
	
	// AUDITOR VER USUARIOS Y PERFILES
	public final static String AUDITOR_USUARIOS = "/perfiles/perfil_auditor/usuario/usuarios";
	public final static String AUDITOR_PERFILES = "/perfiles/perfil_auditor/perfil/roles";
	
	// ADMIN VER USUARIOS Y PERFILES
	public final static String VER_USUARIOS = "/perfiles/perfil_admin/usuario/usuarios";
	public final static String VER_PERFILES = "/perfiles/perfil_admin/perfil/roles";	
	
	//ABM USUARIOS -A DMIN
	public final static String AGREGAR_USUARIO = "/perfiles/perfil_admin/usuario/nuevoUsuario";
	public final static String EDITAR_USUARIO = "/perfiles/perfil_admin/usuario/editarUsuario";
	public final static String ADMIN_USUARIOS = "/admin/usuarios";
	//ABM PERFILES -A DMIN
	public final static String AGREGAR_PERFIL = "/perfiles/perfil_admin/perfil/nuevoRol";
	public final static String EDITAR_PERFIL= "/perfiles/perfil_admin/perfil/editarRol";
	public final static String ADMIN_PERFILES = "/admin/perfiles";
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//EDIFICIO ADMIN
	public final static String EDIFICIO_REDIRECT = "/edificio/admin/index";
	public final static String INDEX_EDIFICIO = "/perfiles/perfil_admin/edificio/index";
	public final static String EDIFICIO_NUEVO = "/perfiles/perfil_admin/edificio/crearEdificio";
	public final static String EDIFICIO_AGREGAR = "/perfiles/perfil_admin/edificio/agregarEdificio";
	public final static String EDIFICIO_EDITAR = "/perfiles/perfil_admin/edificio/editarEdificio";
	public final static String EDIFICIO_EDIT = "/perfiles/perfil_admin/edificio/edit";
	public final static String EDIFICIO_ELIMINAR = "/perfiles/perfil_admin/edificio/eliminarEdificio";
}

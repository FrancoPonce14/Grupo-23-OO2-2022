package com.grupo23.Grupo230022022.helpers;

public class ViewRouteHelper {

	//dashboard
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
	public final static String EDIFICIO_CON_AULAS = "/perfiles/perfil_admin/edificio/verEdificiosConAulas"; //PARA VER EDIFICIOS CON AULA, EL EDIFICIO TIENEN QUE TENER COMO MINIMO 1 AULA, SINO TIRA ERROR (SE PUEDE ARREGLAR, PERO NO LLEGAMOS CON EL TIEMPO)
	//AULA ADMIN
	public final static String AULA_REDIRECT = "/aula/admin/index";
	public final static String INDEX_AULA = "/perfiles/perfil_admin/aula/indexadmin";
	public final static String AULA_SELECT = "/perfiles/perfil_admin/aula/select";
	public final static String AULA_NUEVO_L = "/perfiles/perfil_admin/aula/crearLaboratorio";
	public final static String AULA_NUEVO_T = "/perfiles/perfil_admin/aula/crearTradicional";
	public final static String AULA_EDITAR = "/perfiles/perfil_admin/aula/editarAula";
	public final static String AULA_EDITAR_L = "/perfiles/perfil_admin/aula/editarLaboratorio";
	public final static String AULA_EDITAR_T = "/perfiles/perfil_admin/aula/editarTradicional";
	public final static String AULA_ELIMINAR = "/perfiles/perfil_admin/aula/eliminarAula";
	//ESPACIO ADMIN
	public final static String ESPACIO_REDIRECT = "/espacio/admin/index";
	public final static String INDEX_ESPACIO = "/perfiles/perfil_admin/espacio/index";
	public final static String ESPACIO_NUEVO = "/perfiles/perfil_admin/espacio/crearEspacio";
	public final static String ESPACIO_AGREGAR = "/perfiles/perfil_admin/espacio/agregarEspacio";
	public final static String ESPACIO_EDITAR = "/perfiles/perfil_admin/espacio/editarEspacio";
	public final static String ESPACIO_EDIT = "/perfiles/perfil_admin/espacio/edit";
	public final static String ESPACIO_ELIMINAR = "/perfiles/perfil_admin/espacio/eliminarEspacio";
	//DEPARTAMENTO ADMIN
	public final static String DEPARTAMENTO_REDIRECT = "/departamento/admin/index";
	public final static String INDEX_DEPARTAMENTO = "/perfiles/perfil_admin/departamento/index";
	public final static String DEPARTAMENTO_NUEVO = "/perfiles/perfil_admin/departamento/crearDepartamento";
	public final static String DEPARTAMENTO_AGREGAR = "/perfiles/perfil_admin/departamento/agregarDepartamento";
	public final static String DEPARTAMENTO_EDITAR = "/perfiles/perfil_admin/departamento/editarDepartamento";
	public final static String DEPARTAMENTO_EDIT = "/perfiles/perfil_admin/departamento/edit";
	public final static String DEPARTAMENTO_ELIMINAR = "/perfiles/perfil_admin/departamento/eliminarDepartamento";
}

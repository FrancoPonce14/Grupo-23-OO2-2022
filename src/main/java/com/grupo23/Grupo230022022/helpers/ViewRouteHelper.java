package com.grupo23.Grupo230022022.helpers;

public class ViewRouteHelper {

	// INICIO/CIERRE SESIÓN + INDEXS ADMIN - AUDITOR
	public final static String LOGIN = "/login";
	public final static String LOGOUT = "/logout";
	public final static String INDEX = "/index";
	public final static String PERFIL_AUDITOR = "/auditor/index";
	public final static String INDEX_AUDITOR = "/indexAuditor";
	public final static String PERFIL_ADMIN = "/admin/index";
	public final static String INDEX_ADMIN = "/indexAdmin";
	
	// AUDITOR VER USUARIOS Y PERFILES
	public final static String AUDITOR_USUARIOS = "perfiles/perfil_auditor/usuario/usuarios";
	public final static String AUDITOR_PERFILES = "perfiles/perfil_auditor/perfil/roles";
	
	// ADMIN VER USUARIOS Y PERFILES
	public final static String VER_USUARIOS = "/perfiles/perfil_admin/usuario/usuarios";
	public final static String VER_PERFILES = "/perfiles/perfil_admin/perfil/roles";	
}

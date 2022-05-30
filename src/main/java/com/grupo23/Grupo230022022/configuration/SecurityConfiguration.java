package com.grupo23.Grupo230022022.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grupo23.Grupo230022022.services.implementation.UsuarioService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	//asdasdasd
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
				.antMatchers("/css/*", "/img/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll()
				.antMatchers("/aula/index").hasAuthority("PERFIL_AUDITOR")
				.antMatchers("/admin").hasAuthority("PERFIL_ADMIN")
				.antMatchers("/auditor").hasAuthority("PERFIL_AUDITOR")
				.antMatchers("/admin/*").hasAuthority("PERFIL_ADMIN")
				.antMatchers("/auditor/*").hasAuthority("PERFIL_AUDITOR")
				.antMatchers("/admin/**").hasAuthority("PERFIL_ADMIN")
				.antMatchers("/auditor/**").hasAuthority("PERFIL_AUDITOR")
				.antMatchers("/edificio").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/edificio/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/edificio/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/aula").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/aula/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/aula/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/espacio").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/espacio/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/espacio/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/departamento").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/departamento/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/departamento/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/carrera").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/carrera/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/carrera/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/materia").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/materia/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/materia/**").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/notaPedido").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/notaPedido/*").hasAnyAuthority("PERFIL_ADMIN")
				.antMatchers("/notaPedido/**").hasAnyAuthority("PERFIL_ADMIN")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess", true).permitAll()//index
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
				
	}
}
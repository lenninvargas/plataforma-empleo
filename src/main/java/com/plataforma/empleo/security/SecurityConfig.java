package com.plataforma.empleo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.plataforma.empleo.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // Desactivar CSRF
	        .authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/", "/home", "/registro", "/login").permitAll() // Permitir acceso sin autenticación
	            .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
	        )
	        .formLogin(form -> form
	            .loginPage("/login") // Página de inicio de sesión personalizada
	            .permitAll() // Permitir acceso a la página de inicio de sesión
	        )
	        .logout(logout -> logout
	            .permitAll() // Permitir acceso a la funcionalidad de cierre de sesión
	        );

	    return http.build(); // Construir el objeto HttpSecurity
	}

	
	@Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
            .authenticationProvider(authenticationProvider()); // Usa el DaoAuthenticationProvider
        return authenticationManagerBuilder.build();
    }
	
	
}

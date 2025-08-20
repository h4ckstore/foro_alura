package com.one.foroApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.foroApi.infra.security.DatosJWTtoken;
import com.one.foroApi.infra.security.TokenService;
import com.one.foroApi.modelo.acceso.Acceso;
import com.one.foroApi.modelo.acceso.DatosAutenticacionUsuario;





@RestController
@RequestMapping("/login")
public class AutenticacionController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity autenticarUsuario(@RequestBody DatosAutenticacionUsuario datosAutenticacionUsuario) {
		Authentication authToken= new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(), 
				datosAutenticacionUsuario.clave());
		var usuarioAutenticado = authenticationManager.authenticate(authToken);
		var JWTtoken= tokenService.generarToken((Acceso)usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
		
	}
	

}

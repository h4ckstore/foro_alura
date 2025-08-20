package com.one.foroApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.foroApi.Repository.UsuarioRepository;
import com.one.foroApi.modelo.usuario.DatosRegistroUsuario;
import com.one.foroApi.modelo.usuario.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public void  registrarUsuario(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
		usuarioRepository.save(new Usuario(datosRegistroUsuario));
		System.out.println(datosRegistroUsuario);
	}
	
}

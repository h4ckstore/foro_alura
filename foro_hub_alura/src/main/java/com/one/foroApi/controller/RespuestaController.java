package com.one.foroApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.foroApi.Repository.RespuestaRepository;
import com.one.foroApi.modelo.respuesta.DatosRegistroRespuesta;
import com.one.foroApi.modelo.respuesta.Respuesta;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@PostMapping
	public void registrarRespuesta(@RequestBody DatosRegistroRespuesta datosRegistroRespuesta) {
		respuestaRepository.save(new Respuesta(datosRegistroRespuesta) );
	}

}

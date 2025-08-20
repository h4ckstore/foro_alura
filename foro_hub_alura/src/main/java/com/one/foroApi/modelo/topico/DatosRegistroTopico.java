package com.one.foroApi.modelo.topico;

import com.one.foroApi.modelo.curso.Curso;
import com.one.foroApi.modelo.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
		@NotBlank
		String titulo,
		@NotBlank
		String mensaje,
		@NotNull
		Usuario autor,
		@NotNull
		Curso curso
		) {
	



}




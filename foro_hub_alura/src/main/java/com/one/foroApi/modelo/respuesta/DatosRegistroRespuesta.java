package com.one.foroApi.modelo.respuesta;

import com.one.foroApi.modelo.topico.Topico;
import com.one.foroApi.modelo.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
		@NotBlank
		String mensaje,
		@NotNull
		Topico topico,
		@NotNull
		Usuario autor) {

}

package com.one.foroApi.modelo.topico;

import java.time.LocalDateTime;

import com.one.foroApi.modelo.StatusTopico;

public record DatosListadoTopico(
				Long id,
				String titulo, 
				String mensaje, 
				LocalDateTime fechaCreacion,
				StatusTopico status, 
				String autor, 
				String curso) {
	public DatosListadoTopico(Topico topico) {
		this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
				topico.getStatus(),topico.getAutor().getNombre(),topico.getCurso().getNombre());
	}

}

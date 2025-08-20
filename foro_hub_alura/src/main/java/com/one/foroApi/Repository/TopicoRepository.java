package com.one.foroApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.foroApi.modelo.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	boolean existsByTituloAndMensaje(String titulo, String mensaje);

}

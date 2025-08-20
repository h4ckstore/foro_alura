package com.one.foroApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.foroApi.modelo.curso.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}

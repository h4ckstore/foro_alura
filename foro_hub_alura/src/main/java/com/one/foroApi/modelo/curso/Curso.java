package com.one.foroApi.modelo.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity (name="Curso")
@Table(name="cursos")
@EqualsAndHashCode(of="id")
public class Curso {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nombre;
		private String categoria;
		
		public Curso() {
		}

		public Curso(Long id, String nombre, String categoria) {
			this.id = id;
			this.nombre = nombre;
			this.categoria = categoria;
		}

		public Curso(DatosRegistroCurso datosRegistroCurso) {
			this.nombre = datosRegistroCurso.nombre();
			this.categoria = datosRegistroCurso.categoria();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
		
		
		

}

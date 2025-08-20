package com.one.foroApi.modelo.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.one.foroApi.modelo.StatusTopico;
import com.one.foroApi.modelo.curso.Curso;
import com.one.foroApi.modelo.respuesta.Respuesta;
import com.one.foroApi.modelo.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity (name="Topico")
@Table(name="topicos")
@EqualsAndHashCode(of="id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "topico")
	private List<Respuesta> respuestas = new ArrayList<>();
	
	public Topico() {
	}



	public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status,
			Usuario autor, Curso curso, List<Respuesta> respuestas) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.status = status;
		this.autor = autor;
		this.curso = curso;
		this.respuestas = respuestas;
	}



	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje =datosRegistroTopico.mensaje();
		this.fechaCreacion = LocalDateTime.now();
		this.autor =  datosRegistroTopico.autor();
		this.curso = datosRegistroTopico.curso();
	}
	
	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if(datosActualizarTopico.titulo()!=null) {//Estos if permiten que falten parametros para actualizar
			this.titulo = datosActualizarTopico.titulo();
		}
		if(datosActualizarTopico.mensaje()!=null) {
			this.mensaje = datosActualizarTopico.mensaje();	
		}
		if(datosActualizarTopico.autor()!=null) {
			this.autor = datosActualizarTopico.autor();
		}
		if(datosActualizarTopico.curso()!=null) {
			this.curso = datosActualizarTopico.curso();
		}
	
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}




	
	
	
	

}

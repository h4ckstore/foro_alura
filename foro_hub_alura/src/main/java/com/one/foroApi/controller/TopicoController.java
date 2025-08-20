package com.one.foroApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.foroApi.Repository.TopicoRepository;
import com.one.foroApi.modelo.topico.DatosActualizarTopico;
import com.one.foroApi.modelo.topico.DatosListadoTopico;
import com.one.foroApi.modelo.topico.DatosRegistroTopico;
import com.one.foroApi.modelo.topico.Topico;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	@Autowired
	private TopicoRepository topicoRepository;
	
	@PostMapping
	public void registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
		Topico topicoParaComparar = new Topico(datosRegistroTopico); 
		boolean existe = topicoRepository.existsByTituloAndMensaje(topicoParaComparar.getTitulo(),topicoParaComparar.getMensaje());
		System.out.println("Titulo existe= "+existe);
		System.out.println(datosRegistroTopico);
		if (!existe) {
			topicoRepository.save(new Topico(datosRegistroTopico));
			
		}else {
			System.out.println("Titulo y Mensaje ta existen");
		}
		
				
	}
	@GetMapping
	public List<DatosListadoTopico> listadoTopicos(){
		return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
	}
	@GetMapping("/{id}")
	public ResponseEntity<DatosListadoTopico> listarUnTopico(@PathVariable Long id){
		Topico topico = topicoRepository.getReferenceById(id);
		var datosTopico=new DatosListadoTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
				topico.getStatus(),topico.getAutor().getNombre(),topico.getCurso().getNombre());
		return ResponseEntity.ok(datosTopico);
	}	
	//TODO marca error cuando el id no existe
	
	@PutMapping("/{id}")
	@Transactional
	public void modificarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico) {
		Topico topico = topicoRepository.getReferenceById(id); 
		topico.actualizarDatos(datosActualizarTopico);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminarTopico(@PathVariable Long id) {
//		Topico topico = topicoRepository.getReferenceById(id);
//		topicoRepository.delete(topico); 
		topicoRepository.deleteById(id);
		
	}
	
	
}

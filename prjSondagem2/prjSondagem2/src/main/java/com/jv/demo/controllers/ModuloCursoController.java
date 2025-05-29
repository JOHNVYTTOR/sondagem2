package com.jv.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.demo.entities.ModuloCurso;
import com.jv.demo.services.ModuloCursoService;


@RestController
@RequestMapping("/api/modulos")
public class ModuloCursoController {
	
	@Autowired
	private ModuloCursoService service;
		
	@PostMapping("/{moduloId}")
	public ResponseEntity<ModuloCurso> criar(@RequestBody ModuloCurso modulo){
		return ResponseEntity.status(201).body(service.salvar(modulo));
	}
	
	@GetMapping
	public ResponseEntity<List<ModuloCurso>> listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModuloCurso> buscarPorId(@PathVariable Long id){
		return service.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
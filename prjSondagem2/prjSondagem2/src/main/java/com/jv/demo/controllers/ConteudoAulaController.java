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

import com.jv.demo.entities.ConteudoAula;
import com.jv.demo.services.ConteudoAulaService;


@RestController
@RequestMapping("/api/conteudos")
public class ConteudoAulaController {
	
	@Autowired
	private ConteudoAulaService service;
		
	@PostMapping("/{moduloId}")
	public ResponseEntity<ConteudoAula> criar(@RequestBody ConteudoAula conteudo, @PathVariable Long moduloId){
		return ResponseEntity.status(201).body(service.salvar(conteudo, moduloId));
	}
	
	@GetMapping
	public ResponseEntity<List<ConteudoAula>> listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConteudoAula> buscarPorId(@PathVariable Long id){
		return service.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/modulo{titulo}")
	public ResponseEntity<List<ConteudoAula>> buscarPorModulo(@PathVariable String titulo){
		return ResponseEntity.ok(service.buscarPorModulo(titulo));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
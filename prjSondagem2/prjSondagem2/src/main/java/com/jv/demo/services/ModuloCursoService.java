package com.jv.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.demo.entities.ModuloCurso;
import com.jv.demo.repositories.ModuloCursoRepository;

@Service
public class ModuloCursoService {

	@Autowired
	private ModuloCursoRepository modulocursorepository;
	
	public ModuloCurso salvar(ModuloCurso modulo) {
		return modulocursorepository.save(modulo);
	}
	
	public List<ModuloCurso> listarTodos(){
		return modulocursorepository.findAll();
	}
	
	public Optional<ModuloCurso> buscarPorId(Long id) {
		return modulocursorepository.findById(id);
	}
	
	public void deletar(Long id) {
		modulocursorepository.deleteById(id);
	}
}

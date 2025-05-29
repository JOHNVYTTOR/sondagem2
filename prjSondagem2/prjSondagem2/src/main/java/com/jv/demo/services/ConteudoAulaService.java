package com.jv.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.demo.entities.ConteudoAula;
import com.jv.demo.entities.ModuloCurso;
import com.jv.demo.repositories.ConteudoAulaRepository;
import com.jv.demo.repositories.ModuloCursoRepository;

@Service
public class ConteudoAulaService {

	@Autowired
	private ConteudoAulaRepository conteudoRepository;
	
	@Autowired
	private ModuloCursoRepository moduloRepository;
	
	public ConteudoAula salvar(ConteudoAula conteudo, Long moduloId) {
		Optional<ModuloCurso> modulo = moduloRepository.findById(moduloId);
		if (modulo.isPresent()) {
			conteudo.setModuloCurso(modulo.get());
			return conteudoRepository.save(conteudo);
		} else {
			throw new RuntimeException("Não foi possível encontrar o ModuloCurso " + moduloId);
		}
	}
	
	public List<ConteudoAula> listarTodos(){
		return conteudoRepository.findAll();
	}
	
	public Optional<ConteudoAula> buscarPorId(Long id){
		return conteudoRepository.findById(id);
	}
	public void deletar(Long id) {
		conteudoRepository.deleteById(id);
	}
	
	public List<ConteudoAula> buscarPorModulo(String tituloModulo) {
		return conteudoRepository.findConteudosByModulo(tituloModulo);
	}
}
	
	
	
	

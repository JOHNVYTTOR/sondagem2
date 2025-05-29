package com.jv.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="modulo_curso")
public class ModuloCurso {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String titulo;
	private String descricao;	
	
	@OneToMany(mappedBy = "moduloCurso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ConteudoAula> conteudos;
	
	public ModuloCurso( ) {
		
	}
	public ModuloCurso(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<ConteudoAula> getConteudos(){
		return conteudos;
	}
	
	public void setConteudos(List<ConteudoAula> conteudos) {
		this.conteudos = conteudos;
	}
}
	

	

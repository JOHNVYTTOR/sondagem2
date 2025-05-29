package com.jv.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contedo_aula")
public class ConteudoAula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String tipoConteudo;
	private String url;

	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="modulo_curso_id")
	private ModuloCurso moduloCurso;
	
	public ConteudoAula() {}

	public ConteudoAula(Long id, String titulo, String tipoConteudo, String url, ModuloCurso moduloCurso) {
		this.titulo = titulo;
		this.tipoConteudo = tipoConteudo;
		this.url = url;
		this.moduloCurso = moduloCurso;
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

	public String getTipoConteudo() {
		return tipoConteudo;
	}

	public void setTipoConteudo(String tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ModuloCurso getModuloCurso() {
		return moduloCurso;
	}

	public void setModuloCurso(ModuloCurso moduloCurso) {
		this.moduloCurso = moduloCurso;
	}
}
	

	

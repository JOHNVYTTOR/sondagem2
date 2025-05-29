package com.jv.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jv.demo.entities.ConteudoAula;

public interface ConteudoAulaRepository extends JpaRepository<ConteudoAula, Long> {
	
	@Query("SELECT c FROM ConteudoAula c JOIN c.moduloCurso m WHERE LOWER (m.titulo) = LOWER (:titulo)")
	List<ConteudoAula> findConteudosByModulo(@Param("titulo")String titulo);
}


package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Tener;

@Repository
public interface TenerRepository  extends JpaRepository<Tener, Integer> {
	
	@Query(value="select id_evento from tener where id_tipo = :id_tipo", nativeQuery=true)
	List<Integer> getEventosDeTipo(int id_tipo);
	
	@Query(value="select id_tipo from tener where id_evento = :id_evento", nativeQuery=true)
	List<Integer> getTiposDelEvento(int id_evento);
	
	@Query(value="select * from tener where id_tipo = :id_tipo and id_evento = :id_evento", nativeQuery=true)
	Tener getTener(int id_tipo, int id_evento);
}

package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	@Query(value="SELECT * FROM taekwondobd.evento where fecha_inicio > current_date() order by fecha_inicio", nativeQuery=true)
	List<Evento> getEventosProximos();
}

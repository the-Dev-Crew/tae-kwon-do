package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Relacionar;

@Repository
public interface RelacionarRepository extends JpaRepository<Relacionar, Integer>{
	
	@Query(value="select id_evento from relacionar where actividad = :actividad", nativeQuery=true)
	List<Integer> getRelacionadosConActividad(String actividad);
	
	@Query(value="select actividad from relacionar where id_evento = :id_evento", nativeQuery=true)
	List<String> getActividadesEvento(int id_evento);
	
	@Query(value="select * from relacionar where id_evento = :id_evento and actividad = :actividad", nativeQuery=true)
	Relacionar getRelacionar(int id_evento, String actividad);

}

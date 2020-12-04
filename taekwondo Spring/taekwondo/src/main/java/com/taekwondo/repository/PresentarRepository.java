package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Presentar;

@Repository
public interface PresentarRepository extends JpaRepository<Presentar, Integer> {
	
	@Query(value="select id_examen from presentar where id_alumno = :id_alumno", nativeQuery=true)
	List<Integer> getExamenesPresentados(int id_alumno);
	
	@Query(value="select id_alumno from presentar where id_examen = :id_examen", nativeQuery=true)
	List<Integer> getAlumnosPresentados(int id_examen);
	
	
	@Query(value = "Select * from presentar where id_alumno = :id_alumno and id_examen = :id_examen", nativeQuery=true)
	Presentar getPresentar(int id_alumno, int id_examen);
}

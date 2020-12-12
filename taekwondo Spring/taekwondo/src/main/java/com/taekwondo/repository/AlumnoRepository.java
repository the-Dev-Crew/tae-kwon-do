package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.taekwondo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	@Query(value="SELECT id_Alumno FROM taekwondobd.usuario join taekwondobd.alumno on usuario.username = alumno.username where tipo_usuario = 'alumno'", nativeQuery=true)
	List<Integer> getAlumnos();
}

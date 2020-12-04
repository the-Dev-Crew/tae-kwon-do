package com.taekwondo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Participa;

@Repository
public interface ParticipaRepository extends JpaRepository<Participa, Integer> {
	
	@Query(value="SELECT * FROM participa WHERE id_alumno = :id_alumno", nativeQuery=true)
	List<Participa> getParticipaciones(int id_alumno);
	
	@Query(value="select alumno.id_alumno, alumno.nombre, alumno.a_paterno, alumno.a_materno, alumno.fotografia, alumno.fecha_nacimiento, alumno.seguro_medico, alumno.certificado_medico, alumno.carta_responsiva, alumno.actividad, alumno.grado, alumno.username from alumno join participa on alumno.id_alumno = participa.id_alumno where id_evento = :id_evento", nativeQuery=true)
	List<Map<String,Object>> getAlumnosAsistentes(int id_evento);
	
	@Query(value="select id_alumno from participa where id_evento = :id_evento", nativeQuery=true)
	List<Integer> getAlumnosParticipantes(int id_evento);
	
	@Query(value="delete from participa where (id_alumno = :id_alumno and id_evento = :id_evento)", nativeQuery=true)
	void deleteParticipacion(int id_alumno, int id_evento);
	
	@Query(value="select * from participa where id_alumno = :id_alumno and id_evento = :id_evento", nativeQuery=true)
	Participa getParticipacion(int id_alumno, int id_evento);
	

}

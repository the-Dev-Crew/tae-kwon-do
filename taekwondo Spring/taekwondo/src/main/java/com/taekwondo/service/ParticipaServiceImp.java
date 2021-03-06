package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Evento;
import com.taekwondo.model.Participa;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.repository.EventoRepository;
import com.taekwondo.repository.ParticipaRepository;

@Service
public class ParticipaServiceImp implements ParticipaService {
	
	@Autowired 
	private ParticipaRepository partRepo;
	@Autowired 
	private AlumnoRepository ar;
	@Autowired
	private EventoRepository er;
	
	@Override
	public List<Participa> getParticipaciones() {
		return partRepo.findAll();
	}

	@Override
	public List<Evento> getEventosdeAlumno(int id_alumno) {
		List<Integer> l = partRepo.getEventosdeAlumno(id_alumno);
		List<Evento> eventos = new ArrayList<Evento>();
		
		for(int i = 0 ; i< l.size(); i++) {
			int id = l.get(i);
			Evento aux = er.findById(id).get();
			eventos.add(aux);
		}
		return eventos;
	}
	
	
	@Override
	public List<Alumno> getAlumnosParticipantes(int id_evento) {
		List<Integer> l = partRepo.getAlumnosParticipantes(id_evento);
		List<Alumno> alumnos = new ArrayList<Alumno>();
		for(int i = 0; i < l.size(); i++) {
			int id = l.get(i);
			Alumno aux = ar.findById(id).get();
			alumnos.add(aux);
		}
		return alumnos;
	}

	@Override
	public void createParticipacion(Participa p) {
		partRepo.save(p);
		
	}
	
	@Override
	public void deleteParticipacion(int id) {
		partRepo.deleteById(id);
		
	}

	@Override
	public void deleteParticipacion(int id_alumno, int id_evento) {
		partRepo.deleteParticipacion(id_alumno, id_evento);
		
	}

	@Override
	public Participa getParticipacion(int id_alumno, int id_evento) {
		return partRepo.getParticipacion(id_alumno, id_evento);
		
	}


	


}

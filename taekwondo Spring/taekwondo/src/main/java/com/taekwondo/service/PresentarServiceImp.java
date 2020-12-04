package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Examen;
import com.taekwondo.model.Presentar;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.repository.ExamenRepository;
import com.taekwondo.repository.PresentarRepository;

@Service
public class PresentarServiceImp implements PresentarService {
	
	@Autowired
	private PresentarRepository presentarRepo;
	@Autowired
	private ExamenRepository er;
	@Autowired
	private AlumnoRepository ar;

	@Override
	public List<Presentar> getPresentar() {
		return presentarRepo.findAll();
	}
	
	@Override
	public Presentar getPresentar(int id) {
		return presentarRepo.findById(id).get();
	}

	@Override
	public List<Examen> getExamenesPresentados(int id_alumno) {
		List<Integer> l = presentarRepo.getExamenesPresentados(id_alumno);
		List<Examen> examenes = new ArrayList<Examen>();
		
		for(int i = 0; i < l.size(); i++) {
			int id = l.get(i);
			Examen e = er.findById(id).get();
			examenes.add(e);
		}
		return examenes;
	}

	@Override
	public List<Alumno> getAlumnosPresentados(int id_examen) {
		List<Integer> l = presentarRepo.getAlumnosPresentados(id_examen);
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		for(int i = 0; i< l.size(); i++) {
			int id = l.get(i);
			Alumno a = ar.findById(id).get();
			alumnos.add(a);
		}
		return alumnos;
	}
	
	@Override
	public void createPresentar(Presentar p) {
		presentarRepo.save(p);
		
	}

	@Override
	public void deletePresentar(int id) {
		presentarRepo.deleteById(id);
		
	}

	@Override
	public Presentar getPresentar(int id_alumno, int id_examen) {
		return presentarRepo.getPresentar(id_alumno, id_examen);
	}


	
	


	
}

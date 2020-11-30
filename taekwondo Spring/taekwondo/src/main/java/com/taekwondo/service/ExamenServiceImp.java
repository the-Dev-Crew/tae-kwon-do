package com.taekwondo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Examen;
import com.taekwondo.repository.ExamenRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ExamenServiceImp implements ExamenService {
	
	@Autowired
	private ExamenRepository examenRepo;
	
	@Override
	public List<Examen> getExamenes() {
		return examenRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> getExamen(int id) {
		return new ResponseEntity<>(examenRepo.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createExamen(Examen e) {
		return new ResponseEntity<>(examenRepo.save(e), HttpStatus.OK);
	}

	@Override
	public void updateExamen(int id, Examen e) {
		examenRepo.save(e);
		
	}

	@Override
	public void deleteExamen(int id) {
		examenRepo.deleteById(id);
		
	}

}

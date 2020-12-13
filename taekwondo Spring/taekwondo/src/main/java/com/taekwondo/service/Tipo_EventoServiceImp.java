package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.repository.Tipo_EventoRepository;

@Service
public class Tipo_EventoServiceImp implements Tipo_EventoService {
	
	@Autowired
	private Tipo_EventoRepository repoTipoE;
	
	public List<Tipo_Evento> getTipos_Evento() {
		return repoTipoE.findAll();
	}

	public ResponseEntity<Object> getTipo_Evento(int id) {
		return new ResponseEntity<>(repoTipoE.findById(id), HttpStatus.OK);
	}

	public ResponseEntity<Object> createTipo_Evento(Tipo_Evento te) {
		return new ResponseEntity<>(repoTipoE.save(te), HttpStatus.OK);
	}

	public void updateTipo_Evento(int id, Tipo_Evento te) {
		repoTipoE.save(te);
	}

	public void deleteTipo_Evento(int id) {
		repoTipoE.deleteById(id);
		
	}

}

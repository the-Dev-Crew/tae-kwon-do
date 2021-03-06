package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Evento;
import com.taekwondo.repository.EventoRepository;

@Service
public class EventoServiceImp implements EventoService {
	@Autowired
	private EventoRepository eventoRepo;
	
	@Override
	public List<Evento> getEventos() {
		return eventoRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> getEvento(int id) {
		return new ResponseEntity<>(eventoRepo.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createEvento(Evento e) {
		return new ResponseEntity<>(eventoRepo.save(e), HttpStatus.OK);
	}

	@Override
	public void updateEvento(int id, Evento e) {
		eventoRepo.save(e);
		
	}

	@Override
	public void deleteEvento(int id) {
		eventoRepo.deleteById(id);
		
	}

	@Override
	public List<Evento> getEventosProximos() {
		List<Evento> eventos = eventoRepo.getEventosProximos();
		List<Evento> eventosProximos = new ArrayList<Evento>();
		if(eventos.size() >= 2) {
			eventosProximos.add(eventos.get(0));
			eventosProximos.add(eventos.get(1));
		}else {
			eventosProximos = eventos;
		}
		return eventosProximos;
	}

}

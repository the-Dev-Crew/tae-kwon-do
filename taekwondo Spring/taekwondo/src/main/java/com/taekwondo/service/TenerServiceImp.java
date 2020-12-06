package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Evento;
import com.taekwondo.model.Tener;
import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.repository.EventoRepository;
import com.taekwondo.repository.TenerRepository;
import com.taekwondo.repository.Tipo_EventoRepository;

@Service
public class TenerServiceImp implements TenerService {
	
	@Autowired
	private TenerRepository tenRepo;
	@Autowired
	private EventoRepository evRepo;
	@Autowired 
	private Tipo_EventoRepository tipoRepo;
	
	@Override
	public List<Tener> getTener() {
		return tenRepo.findAll();
	}

	@Override
	public List<Evento> getEventosConTipo(int id_tipo) {
		List<Integer> l = tenRepo.getEventosDeTipo(id_tipo);
		List<Evento> eventos = new ArrayList<Evento>();
		
		for(int i = 0; i < l.size(); i++) {
			int id = l.get(i);
			Evento e = evRepo.findById(id).get();
			eventos.add(e);
		}
		return eventos;
	}

	@Override
	public List<Tipo_Evento> getTiposDelEvento(int id_evento) {
		List<Integer> l  = tenRepo.getTiposDelEvento(id_evento);
		List<Tipo_Evento> tipos = new ArrayList<Tipo_Evento>();
		
		for(int i = 0; i < l.size(); i++) {
			int id = l.get(i);
			Tipo_Evento  t = tipoRepo.findById(id).get();
			tipos.add(t);
		}
		return tipos;
	}

	@Override
	public Tener getTener(int id_tipo, int id_evento) {
		return tenRepo.getTener(id_tipo, id_evento);
	}

	@Override
	public void createTener(Tener t) {
		tenRepo.save(t);
		
	}

	@Override
	public void deleteTener(int id_tener) {
		tenRepo.deleteById(id_tener);
		
	}

}

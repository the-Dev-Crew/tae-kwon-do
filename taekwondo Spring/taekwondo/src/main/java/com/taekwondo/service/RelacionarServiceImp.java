package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Evento;
import com.taekwondo.model.Relacionar;
import com.taekwondo.repository.EventoRepository;
import com.taekwondo.repository.RelacionarRepository;

@Service
public class RelacionarServiceImp implements RelacionarService{
	@Autowired
	private RelacionarRepository relRepo;
	@Autowired
	private EventoRepository evRepo;
	
	@Override
	public List<Relacionar> getRelacionar() {
		return relRepo.findAll();
	}
	@Override
	public List<Evento> getRelacionadosConActividad(String actividad) {
		List<Integer> l = relRepo.getRelacionadosConActividad(actividad);
		List<Evento> eventos = new ArrayList<Evento>();
		for(int i = 0; i < l.size();i++) {
			int id = l.get(i);
			Evento e = evRepo.findById(id).get();
			eventos.add(e);
		}
		return eventos;
	}
	@Override
	public List<String> getActividadesEvento(int id_evento) {
		return relRepo.getActividadesEvento(id_evento);
	}
	@Override
	public Relacionar getRelacionar(int id_evento, String actividad) {
		return relRepo.getRelacionar(id_evento, actividad);
	}
	@Override
	public void createRelacionar(Relacionar r) {
		relRepo.save(r);
		
	}
	@Override
	public void deleteRelacionar(int id_relacionar) {
		relRepo.deleteById(id_relacionar);
		
	}
	
	
	
}

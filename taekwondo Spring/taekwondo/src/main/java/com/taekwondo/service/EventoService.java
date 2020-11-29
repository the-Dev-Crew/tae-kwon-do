package com.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.*;

public interface EventoService {
	public abstract List<Evento> getEventos();
	public abstract ResponseEntity<Object> getEvento(int id);
	public abstract ResponseEntity<Object> createEvento(Evento e);
	public abstract void updateEvento(int id, Evento e);
	public abstract void deleteEvento(int id);
}

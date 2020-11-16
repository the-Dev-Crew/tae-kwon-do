package com.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.*;

public interface Tipo_EventoService {
	public abstract List<Tipo_Evento> getTipos_Evento();
	public abstract ResponseEntity<Object> getTipo_Evento(int id);
	public abstract ResponseEntity<Object> createTipo_Evento(Tipo_Evento te);
	public abstract void updateTipo_Evento(int id, Tipo_Evento te);
	public abstract void deleteTipo_Evento(int id);

}

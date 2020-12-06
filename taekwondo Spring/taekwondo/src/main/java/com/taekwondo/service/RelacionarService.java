package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Relacionar;
import com.taekwondo.model.Evento;

public interface RelacionarService {
	public abstract List<Relacionar> getRelacionar();
	public abstract List<Evento> getRelacionadosConActividad(String actividad);
	public abstract List<String> getActividadesEvento(int id_evento);
	public abstract Relacionar getRelacionar(int id_evento, String actividad);
	public abstract void createRelacionar(Relacionar r);
	public abstract void deleteRelacionar(int id_relacionar);
	
	
}

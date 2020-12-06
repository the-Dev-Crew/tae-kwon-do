package com.taekwondo.service;
import java.util.List;

import com.taekwondo.model.Tener;
import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.model.Evento;

public interface TenerService {
	public abstract List<Tener> getTener();
	public abstract List<Evento> getEventosConTipo(int id_tipo);
	public abstract List<Tipo_Evento> getTiposDelEvento(int id_evento);
	public abstract Tener getTener(int id_tipo, int id_evento);
	public abstract void createTener(Tener t);
	public abstract void deleteTener(int id_tener);
	

}

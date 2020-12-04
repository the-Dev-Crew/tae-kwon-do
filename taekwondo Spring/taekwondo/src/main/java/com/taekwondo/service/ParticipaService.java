package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Participa;

public interface ParticipaService {
	public abstract List<Participa> getParticipaciones();
	public abstract List<Participa> getParticipaciones(int id_alumno);
	public abstract List<Alumno> getAlumnosParticipantes(int id_evento);
	public abstract void createParticipacion(Participa p);
	public abstract void deleteParticipacion(int id);
	public abstract void deleteParticipacion(int id_alumno, int id_evento);
	public abstract Participa getParticipacion(int id_alumno, int id_evento);
}

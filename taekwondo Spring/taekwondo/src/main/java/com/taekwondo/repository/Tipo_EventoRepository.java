package com.taekwondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Tipo_Evento;

@Repository
public interface Tipo_EventoRepository extends JpaRepository<Tipo_Evento, Integer>{

}

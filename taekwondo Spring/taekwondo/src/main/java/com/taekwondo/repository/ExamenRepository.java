package com.taekwondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {

}

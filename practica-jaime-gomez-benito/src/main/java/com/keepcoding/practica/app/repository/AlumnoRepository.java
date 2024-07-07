package com.keepcoding.practica.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keepcoding.practica.app.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}

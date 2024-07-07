package com.keepcoding.practica.app.service;

import java.util.List;

import com.keepcoding.practica.app.entity.Alumno;

public interface AlumnoService {
    List<Alumno> getAllAlumnos();
    Alumno getAlumnoById(Long id);
    Alumno saveAlumno(Alumno alumno);
    void deleteAlumno(Long id);
}

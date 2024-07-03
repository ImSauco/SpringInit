package com.keepcoding.intro.app.service;

import java.util.List;
import com.keepcoding.intro.app.entity.Persona;

//Aquí definimos os métodos que vamos a tener
public interface PersonaService {
	//métodos abstractos
	//método que devuleva un listado de objetos persona
	List<Persona> listaPersona();
	//método que inserta
	void insertaPersona();
}

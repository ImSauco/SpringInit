package com.keepcoding.intro.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.intro.app.entity.Persona;
import com.keepcoding.intro.app.service.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/persona")
	public List<Persona> listado(){
		return personaService.listaPersona();
	}
	
	@GetMapping("/newpersona")
	public String insert() {
		personaService.insertaPersona();
		return "Persona insertada";
	}

}

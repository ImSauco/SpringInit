package com.keepcoding.intro.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.intro.app.entity.Persona;
import com.keepcoding.intro.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	Persona persona;
	//declaro lista persona
	List<Persona> lista =new ArrayList<>();
			
	Persona objPersona;
	Persona objPersona2;
	Persona objPersona3;
	
			
	@Override
	public List<Persona> listaPersona() {
		if (lista.size() ==0 || lista.size() ==1 ) {
		objPersona = new Persona("Carlos","Perez","12345678x","cp@mail.com",666777444);
		objPersona2 = new Persona("Carlo","Perez","12345679y","cp2@mail.com",666777445);
		objPersona3 = new Persona("Carl","Perez","12345680z","cp3@mail.com",666777446);
		lista.add(objPersona);
		lista.add(objPersona2);
		lista.add(objPersona3);
		}
		return lista;
	}

	@Override
	public void insertaPersona() {
		persona.setNombre("Carlos");
		persona.setApellido("Perez");
		persona.setEmail("Carlospz@yahoo.com");
		persona.setDni("12345679y");
		persona.setTelefono(666666667);
		lista.add(persona);
		
	}
	

}

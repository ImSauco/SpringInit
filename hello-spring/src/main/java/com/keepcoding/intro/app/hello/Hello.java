package com.keepcoding.intro.app.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.intro.app.entity.Persona;

@RestController /*Esto es un controlador*/

public class Hello {
	@Autowired //Esto va con el @Component en la class 
	Persona persona;
//	Persona objPersona;
//	Persona objPersona2;
//	Persona objPersona3;
	List listaPersona= null;
	
	@GetMapping("/saludar")
 
	public List<Persona> saludar() {
//		objPersona = new Persona("Carlos", "Perez", "12345678x","cperez@s.com",666555444);
//		objPersona2 = new Persona("Carlo", "Perez", "12345678x","cperez@s.com",666555444);
//		objPersona3 = new Persona("Carl", "Perez", "12345678x","cperez@s.com",666555444);
		listaPersona= new ArrayList<>();
		persona.setNombre("Paco");
		persona.setApellido("Lopez");
		persona.setDni("12345678z");
		persona.setEmail("plopez@yahoo.com");
		persona.setTelefono(333333333);
		listaPersona.add(persona);
//		listaPersona.add(objPersona);
//		listaPersona.add(objPersona2);
//		listaPersona.add(objPersona3);
		return listaPersona;
	}
}

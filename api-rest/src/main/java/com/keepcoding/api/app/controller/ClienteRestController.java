package com.keepcoding.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.api.app.entity.Cliente;
import com.keepcoding.api.app.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.buscarTodos();
		
	}
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	}

	@GetMapping("/clientes/{nombre}/{apellido}")
	public List<Cliente> searchname(@PathVariable String nombre, @PathVariable String apellido){
		return clienteService.buscarPorNombreApellido(nombre, apellido);
	}
	@GetMapping("/clientes/{email}/{telefono}")
	public List<Cliente> searchname(@PathVariable String email, @PathVariable int telefono){
		return clienteService.buscarPorEmailTelefono(email, telefono);
	}
}

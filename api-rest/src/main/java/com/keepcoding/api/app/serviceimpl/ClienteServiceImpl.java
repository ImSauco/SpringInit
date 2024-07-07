package com.keepcoding.api.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.api.app.entity.Cliente;
import com.keepcoding.api.app.repository.ClienteRepository;
import com.keepcoding.api.app.service.ClienteService;



@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> buscarPorNombreApellido(String nombre, String apellido) {
		
		return clienteRepository.findByNombreAndApellido(nombre, apellido);
	}

	@Override
	public List<Cliente> buscarPorEmailTelefono(String email, int telefono) {
		
		return clienteRepository.findByEmailAndTelefono(email, telefono);
		
	}
	
	
	
	
}

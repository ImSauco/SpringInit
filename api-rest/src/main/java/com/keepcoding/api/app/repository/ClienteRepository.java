package com.keepcoding.api.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.api.app.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	List<Cliente> findByApellido(String apellido);
	@Query("select c from Cliente c where c.apellido= ?1")
	List<Cliente> findByApellido2(String apellido);
	List<Cliente> findByNombreAndApellido(String nombre, String apellido);
	@Query("select c from Cliente c where c.name= ?1 and c.apellido =?2")
	List<Cliente> findByNombreAndApellido2(String nombre, String apellido);
	List<Cliente> findByEmailAndTelefono(String email, int telefono);
	@Query("select c from Cliente c where c.email =?1 and c.telefono = ?2")
	List<Cliente> findByEmailAndTelefono2(String email, int telefono);
}

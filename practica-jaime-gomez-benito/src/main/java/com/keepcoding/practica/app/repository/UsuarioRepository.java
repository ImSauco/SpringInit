package com.keepcoding.practica.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keepcoding.practica.app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

}

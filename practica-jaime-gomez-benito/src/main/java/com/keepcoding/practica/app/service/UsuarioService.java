package com.keepcoding.practica.app.service;

import com.keepcoding.practica.app.entity.Usuario;


public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);
    Usuario getUsuarioByUsername(String username);
}
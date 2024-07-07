package com.keepcoding.practica.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepcoding.practica.app.entity.Usuario;
import com.keepcoding.practica.app.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registerUser(@ModelAttribute Usuario usuario) {
        usuario.setPassword(usuario.getPassword());  
        usuario.setActivo(true);
        usuarioService.saveUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, Model model) {
        Usuario foundUsuario = usuarioService.getUsuarioByUsername(usuario.getUsername());
        if (foundUsuario != null && foundUsuario.getPassword().equals(usuario.getPassword())) {
            
            return "redirect:/alumnos";
        } else {
            
            model.addAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
            return "login"; 
        }
    }
}
package com.keepcoding.practica.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepcoding.practica.app.entity.Alumno;
import com.keepcoding.practica.app.service.AlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public String getAllAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String showAlumnoForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "matricular-alumnos";
    }

    @PostMapping
    public String saveAlumno(@ModelAttribute Alumno alumno, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "matricular-alumnos";
        }
        alumnoService.saveAlumno(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Alumno alumno = alumnoService.getAlumnoById(id);
        model.addAttribute("alumno", alumno);
        return "editar-alumno";
    }

    @PostMapping("/editar/{id}")
    public String updateAlumno(@PathVariable Long id, @ModelAttribute Alumno alumno) {
        alumno.setId(id); 
        alumnoService.saveAlumno(alumno); 
        return "redirect:/alumnos"; 
    }

    @GetMapping("/eliminar/{id}")
    public String deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return "redirect:/alumnos";
    }
}

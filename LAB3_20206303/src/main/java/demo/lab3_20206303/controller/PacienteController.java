package demo.lab3_20206303.controller;
import demo.lab3_20206303.entity.*;
import demo.lab3_20206303.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import demo.lab3_20206303.repository.DoctorRepository;
import demo.lab3_20206303.repository.HospitalRepository;

import java.util.List;


@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        model.addAttribute("contenido", "paciente/lista");
        return "paciente/listar";
    }

    @GetMapping("/derivar")
    public String derivarFormulario(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        model.addAttribute("contenido", "paciente/derivar");
        return "paciente/formulario";
    }

}

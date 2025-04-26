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
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String listarHospitales(Model model) {
        model.addAttribute("hospitales", hospitalRepository.findAll());
        model.addAttribute("contenido", "hospital/lista");
        return "hospital/lista";
    }

    @GetMapping("/{id}/doctores")
    public String listarDoctores(@PathVariable Integer id, Model model) {
        model.addAttribute("doctores", doctorRepository.findById(id));
        model.addAttribute("contenido", "doctor/lista");
        return "doctor/lista";
    }

    @GetMapping("/{id}/pacientes")
    public String listarPacientes(@PathVariable Integer id, Model model) {
        model.addAttribute("pacientes", pacienteRepository.findById(id));
        model.addAttribute("contenido", "paciente/lista");
        return "paciente/lista";
    }
}

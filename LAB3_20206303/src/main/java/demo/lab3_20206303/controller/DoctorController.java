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
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String listarDoctores(Model model) {
        model.addAttribute("doctor", doctorRepository.findAll());
        model.addAttribute("contenido", "doctor/lista");
        return "doctor/lista";
    }
}

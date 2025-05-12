package demo.lab3_20206303.controller;

import demo.lab3_20206303.entity.Doctor;
import demo.lab3_20206303.entity.Paciente;
import demo.lab3_20206303.repository.DoctorRepository;
import demo.lab3_20206303.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String listarDoctores(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        return "doctor/lista";
    }

    @GetMapping("/{id}/citas")
    public String listarCitasPendientes(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pacientes", pacienteRepository.findPacientesNoAtendidosPorDoctor(id));
        return "paciente/citas";
    }
}

package demo.lab3_20206303.controller;
import demo.lab3_20206303.entity.Paciente;
import demo.lab3_20206303.repository.PacienteRepository;
import demo.lab3_20206303.repository.DoctorRepository;
import demo.lab3_20206303.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "paciente/lista";
    }

    @GetMapping("/derivar")
    public String mostrarFormularioDerivar(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        return "paciente/derivar";
    }

    @PostMapping("/derivar")
    public String derivarPacientes(@RequestParam("doctorOrigenId") Integer doctorOrigenId,
                                   @RequestParam("doctorDestinoId") Integer doctorDestinoId) {
        pacienteRepository.derivarPacientesEntreDoctores(doctorOrigenId, doctorDestinoId);
        return "redirect:/paciente";
    }
}

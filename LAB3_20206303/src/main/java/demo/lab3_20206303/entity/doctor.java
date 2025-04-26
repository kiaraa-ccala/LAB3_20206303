package demo.lab3_20206303.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private hospital hospital;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<paciente> pacientes;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public hospital getHospital() {
        return hospital;
    }
    public void setHospital(hospital hospital) {
        this.hospital = hospital;
    }

    public List<paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<paciente> pacientes) {
        this.pacientes = pacientes;
    }
}

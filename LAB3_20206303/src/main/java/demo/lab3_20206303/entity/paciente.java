package demo.lab3_20206303.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer edad;
    private String genero;
    private String diagnostico;
    private String fechaCita;
    private Integer numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private hospital hospital;

    // Getters y Setters
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

    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(doctor doctor) {
        this.doctor = doctor;
    }

    public hospital getHospital() {
        return hospital;
    }
    public void setHospital(hospital hospital) {
        this.hospital = hospital;
    }
}

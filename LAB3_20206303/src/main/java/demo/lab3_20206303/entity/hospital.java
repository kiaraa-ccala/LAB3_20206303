package demo.lab3_20206303.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<doctor> doctores;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
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

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<doctor> getDoctores() {
        return doctores;
    }
    public void setDoctores(List<doctor> doctores) {
        this.doctores = doctores;
    }

    public List<paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<paciente> pacientes) {
        this.pacientes = pacientes;
    }
}

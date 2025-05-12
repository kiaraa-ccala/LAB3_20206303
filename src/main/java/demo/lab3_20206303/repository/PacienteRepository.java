package demo.lab3_20206303.repository;

import demo.lab3_20206303.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital_Id(Integer hospitalId);
    List<Paciente> findByDoctor_Id(Integer doctorId);
}
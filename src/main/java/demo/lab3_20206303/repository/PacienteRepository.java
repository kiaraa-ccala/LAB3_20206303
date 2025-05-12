package demo.lab3_20206303.repository;

import demo.lab3_20206303.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital_Id(Integer hospitalId);
    List<Paciente> findByDoctor_Id(Integer doctorId);
    @Modifying
    @Transactional
    @Query("UPDATE Paciente p SET p.doctor.id = :nuevoDoctorId WHERE p.doctor.id = :doctorActualId")
    void derivarPacientesEntreDoctores(@Param("doctorActualId") Integer doctorActualId,
                                       @Param("nuevoDoctorId") Integer nuevoDoctorId);
    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId")
    List<Paciente> findPacientesNoAtendidosPorDoctor(@Param("doctorId") Integer doctorId);
}

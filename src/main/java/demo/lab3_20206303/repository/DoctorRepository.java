package demo.lab3_20206303.repository;

import demo.lab3_20206303.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByHospital_Id(Integer hospitalId);  // si lo necesitas para otras vistas
}

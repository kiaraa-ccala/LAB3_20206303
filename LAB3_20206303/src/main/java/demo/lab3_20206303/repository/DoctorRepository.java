package demo.lab3_20206303.repository;

import demo.lab3_20206303.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface DoctorRepository extends JpaRepository<doctor, Integer> {

    @Query("SELECT e FROM doctor e WHERE " +
            "LOWER(e.nombre) LIKE LOWER(CONCAT('%', :filter, '%')) "
           )
    List<doctor> searchByFilter(@Param("filter") String filter);

}

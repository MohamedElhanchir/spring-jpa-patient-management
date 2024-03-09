package ma.enset.jpaap.repositories;

import ma.enset.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    Page<Patient> findByMalade(boolean malade, Pageable pageable);
    List<Patient> findByNameContains(String name);
    List<Patient> findByNameContainsAndMalade(String name, boolean malade);
    List<Patient> findByMaladeIsTrueAndAndScore(int score);
    List<Patient> findByDateOfBirthBetween(Date date1, Date date2);

    //chercher un patient par son nom et son date de naissance entre deux dates

    @Query("select p from Patient p where p.name like :x and p.dateOfBirth > :y and p.dateOfBirth < :z")
    List<Patient> chercher(@Param("x") String name, @Param("y") Date date1, @Param("z") Date date2);
}

package com.example.demo.Repository;

import com.example.demo.Entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {

    @Query("SELECT s FROM PersonalInformation s WHERE s.employee_registrationNumber=?1")
    Optional<PersonalInformation> findPersonbyRegistrationNumber(Integer registratonnumber);

    @Query("SELECT s FROM PersonalInformation s WHERE s.employee_id=?1")
    Optional<PersonalInformation> findPersonalInformationByEmployee_id(Long employee_id);

}

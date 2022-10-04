package com.example.demo.Repository;

import com.example.demo.Entity.EntryExitInformation;
import com.example.demo.Entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryExitınformationReporsitory extends JpaRepository<EntryExitInformation, Long> {

    @Query("SELECT s FROM EntryExitInformation s WHERE s.entryexit_id=?1")
    Optional<EntryExitInformation> findEntryExitInformationBy_id(Long entryexit_id);

//    @Query("DELETE FROM EntryExitInformation s WHERE s.employee_id =?1")
//    Optional<EntryExitInformation> deletePersonbyEmployeeId(Long entryexit_id);
//
//    @Query("DELETE FROM EntryExitInformation s WHERE s.inventory_id =?1")
//    Optional<EntryExitInformation> deleteInventorybyInventoryId(Long inventory_id);

}

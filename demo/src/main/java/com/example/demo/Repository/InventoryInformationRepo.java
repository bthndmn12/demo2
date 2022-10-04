package com.example.demo.Repository;

import com.example.demo.Entity.InventoryInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryInformationRepo extends JpaRepository<InventoryInformation, Long> {

    @Query("SELECT s FROM InventoryInformation s WHERE s.inventory_serialnumber=?1")
    Optional<InventoryInformation> findInventoryInformationByInventory_serialnumber(Integer serialnumber);

    @Query("SELECT s FROM InventoryInformation s WHERE s.inventory_id=?1")
    Optional<InventoryInformation> findInventoryInformationByInventory_id(Long inventory_id);
}

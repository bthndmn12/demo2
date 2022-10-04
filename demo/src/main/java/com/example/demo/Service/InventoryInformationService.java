package com.example.demo.Service;

import com.example.demo.Entity.InventoryInformation;
import com.example.demo.Repository.InventoryInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryInformationService {


    @Autowired
    public InventoryInformationService(InventoryInformationRepo inventoryInformationRepo) {
        this.inventoryInformationRepo = inventoryInformationRepo;
    }

    private final InventoryInformationRepo inventoryInformationRepo;

    public List<InventoryInformation> getInventoryInfo() {
        return inventoryInformationRepo.findAll();
    }

    public void addNewInventoryInfo(InventoryInformation inventory) {
        Optional<InventoryInformation> inventorybySerialNumber = inventoryInformationRepo
                .findInventoryInformationByInventory_serialnumber(inventory.getInventory_serialnumber());
        if (inventorybySerialNumber.isPresent()){
            throw new IllegalStateException("serial taken");
        }
        inventoryInformationRepo.save(inventory);

        System.out.println(inventory);
    }

    public void updateInventory(InventoryInformation inventory, Long id) {
       /* Optional<InventoryInformation> inventoryInformationByInventory_id = inventoryInformationRepo
                .findInventoryInformationByInventory_id(inventory.getInventory_id());
        if (!inventoryInformationByInventory_id.isPresent()){
            throw new IllegalStateException("id number is not taken yet");
        }
        inventoryInformationRepo.save(inventory);
        System.out.println(inventory);

        */
        Optional<InventoryInformation> inventoryInformationById = inventoryInformationRepo.findById(id);

        InventoryInformation inventoryInformation = new InventoryInformation();

        inventoryInformation.setInventory_id(inventoryInformationById.get().getInventory_id());
        inventoryInformation.setInventory_type(inventory.getInventory_type());
        inventoryInformation.setInventory_date(inventory.getInventory_date());
        inventoryInformation.setInventory_model(inventory.getInventory_model());
        inventoryInformation.setInventory_statue(inventory.getInventory_statue());
        inventoryInformation.setInventory_entrancedate(inventory.getInventory_entrancedate());
        inventoryInformation.setInventory_date(inventory.getInventory_date());
        inventoryInformation.setInventory_serialnumber(inventory.getInventory_serialnumber());

        inventoryInformationRepo.save(inventoryInformation);
        System.out.println(inventoryInformation);
    }

    public void deleteInventory(Long inventory_id) {
        boolean exists =inventoryInformationRepo.existsById(inventory_id);
        if(!exists){
            throw new IllegalStateException("Employee id:"+inventory_id+" doesn't exist.");
        }
        inventoryInformationRepo.deleteById(inventory_id);
    }
}

package com.example.demo.Service;

import com.example.demo.Entity.EntryExitInformation;
import com.example.demo.Entity.PersonalInformation;
import com.example.demo.Repository.EntryExitınformationReporsitory;
import com.example.demo.Repository.PersonalInformationRepository;
import com.example.demo.Entity.InventoryInformation;
import com.example.demo.Repository.InventoryInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryExitInformationService {

    @Autowired
    public EntryExitInformationService(EntryExitınformationReporsitory entryExitınformationReporsitory,
                                       PersonalInformationRepository personalInformationRepository,
                                       InventoryInformationRepo inventoryInformationRepo) {
        this.entryExitınformationReporsitory = entryExitınformationReporsitory;
        this.personalInformationRepository = personalInformationRepository;
        this.inventoryInformationRepo = inventoryInformationRepo;
    }

    private final EntryExitınformationReporsitory entryExitınformationReporsitory;
    private final PersonalInformationRepository personalInformationRepository;
    private final InventoryInformationRepo inventoryInformationRepo;


    public List<EntryExitInformation> getEntryExitInfo() {
        return entryExitınformationReporsitory.findAll();
    }

    public Optional<EntryExitInformation> getEntryExit(Long entryexit_id){
        return entryExitınformationReporsitory.findById(entryexit_id);

    }

    public void addNewInventoryInfo(EntryExitInformation inventory, Long inventory_id, Long employee_id) {

        EntryExitInformation entryExitInformation = new EntryExitInformation();

        Optional<EntryExitInformation> inventorybyIdNumber = entryExitınformationReporsitory
                .findEntryExitInformationBy_id(inventory.getEntryexit_id());

        Optional<PersonalInformation> findByIdEmployee = personalInformationRepository.findById(employee_id);
        Optional<InventoryInformation> findByIdInventory= inventoryInformationRepo.findById(inventory_id);

        if (inventorybyIdNumber.isPresent()){
            throw new IllegalStateException("serial taken");
        }

        entryExitInformation.setInventoryInformation(findByIdInventory.get());
        entryExitInformation.setPersonalInformation(findByIdEmployee.get());
        entryExitInformation.setEntryexit_id(inventory.getEntryexit_id());
        entryExitInformation.setEntryexit_backdate(inventory.getEntryexit_backdate());
        entryExitInformation.setEntryexit_takedate(inventory.getEntryexit_takedate());

        entryExitınformationReporsitory.save(entryExitInformation);

        System.out.println(entryExitInformation);
    }
//
//    public void updateInventory(EntryExitInformation inventory, Long id) {
//        Optional<EntryExitInformation> inventoryInformationByInventory_id = entryExitınformationReporsitory
//                .findInventoryInformationByInventory_id(inventory.getInventory_id());
//        if (!inventoryInformationByInventory_id.isPresent()){
//            throw new IllegalStateException("id number is not taken yet");
//        }
//        entryExitınformationReporsitory.save(inventory);
//        System.out.println(inventory);
//    }
//
//        public void updateEntryExit(EntryExitInformation entryExit, Long entryexit_id){
//            Optional<EntryExitInformation> findById = entryExitınformationReporsitory.findById(entryexit_id);
//            EntryExitInformation entryExitInformation = new EntryExitInformation();
//
//            entryExitInformation.setEntryexit_id(findById.get().getEntryexit_id());
//            entryExitInformation.setEntryexit_takedate(entryExit.getEntryexit_takedate());
//            entryExitInformation.setEntryexit_backdate(entryExit.getEntryexit_backdate());
//            entryExitInformation.setPersonalInformation(entryExit.getPersonalInformation());
//            entryExitInformation.setInventoryInformation(entryExit.getInventoryInformation());
//
//
//            entryExitınformationReporsitory.save(entryExitInformation);
//            System.out.println(entryExitInformation);
//        }


  //  public void updateInventory()
    public void deleteEntryExit(Long entryexit_id) {
        boolean exists =entryExitınformationReporsitory.existsById(entryexit_id);
        if(!exists){
            throw new IllegalStateException("Employee id:"+entryexit_id+" doesn't exist.");
        }
        entryExitınformationReporsitory.deleteById(entryexit_id);
    }

}

package com.example.demo.Controller;
import com.example.demo.Entity.EntryExitInformation;
import com.example.demo.Entity.PersonalInformation;
import com.example.demo.Repository.EntryExitınformationReporsitory;
import com.example.demo.Service.EntryExitInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class EntryExitInformationController {

    private final EntryExitInformationService entryExitInformationService;

    @Autowired
    private EntryExitınformationReporsitory entryExitınformationReporsitory;

    @Autowired
    public EntryExitInformationController(EntryExitInformationService entryExitInformationService) {
        this.entryExitInformationService = entryExitInformationService;
    }


    @GetMapping("/entryexit")
    public List<EntryExitInformation> getEntryExitInfo(){
        return entryExitInformationService.getEntryExitInfo();
    }

    @GetMapping("/entryexit/{entryexit_id}")
    public Optional<EntryExitInformation> getEntryExit(@PathVariable("entryexit_id") Long entryexit_id){
        return entryExitInformationService.getEntryExit(entryexit_id);
    }

    @PostMapping("/entryexit/post/{inventory_id}/{employee_id}")
    public void addNewInventoryInfo(@RequestBody EntryExitInformation inventory,@PathVariable("inventory_id") Long inventory_id,
                                       @PathVariable("employee_id") Long employee_id ){
        entryExitInformationService.addNewInventoryInfo(inventory,inventory_id ,employee_id);
    }

//    @PutMapping(path = "/entryexit/put/{inventory_id}")
//    public void updateInventory(@RequestBody EntryExitInformation inventory,@PathVariable("inventory_id") Long id){
//        entryExitInformationService.updateInventory(inventory, id);
//    }
//
//
    @DeleteMapping(path = "/entryexit/delete/{entryexit_id}")
    public void  deleteInventory(@PathVariable("entryexit_id") Long entryexit_id){
        entryExitInformationService.deleteEntryExit(entryexit_id);
    }
    @PutMapping("/entryexit/put")
    public EntryExitInformation updateEntryExit(@RequestBody EntryExitInformation entryExitInformation) {
        return entryExitınformationReporsitory.save(entryExitInformation);
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.InventoryInformation;
import com.example.demo.Service.InventoryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class InventoryInformationController {

    private final InventoryInformationService inventoryInformationService;

    @Autowired
    public InventoryInformationController(InventoryInformationService inventoryInformationService) {
        this.inventoryInformationService = inventoryInformationService;
    }


    @GetMapping("/inventoryinfo")
    public List<InventoryInformation> getInventoryInfo(){
        return inventoryInformationService.getInventoryInfo();
    }


    @PostMapping("/inventoryinfo/post")
    public void registerNewInventory(@RequestBody InventoryInformation inventory){
        inventoryInformationService.addNewInventoryInfo(inventory);
    }

    @PutMapping(path = "/inventoryinfo/put/{inventory_id}")
    public void updateInventory(@RequestBody InventoryInformation inventory,@PathVariable("inventory_id") Long id){
        inventoryInformationService.updateInventory(inventory, id);
    }


    @DeleteMapping(path = "/inventoryinfo/delete/{inventory_id}")
    public void  deleteInventory(@PathVariable("inventory_id") Long inventory_id){
        inventoryInformationService.deleteInventory(inventory_id);
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.PersonalInformation;
import com.example.demo.Repository.PersonalInformationRepository;
import com.example.demo.Service.PersonalInformationService;
import com.example.demo.dto.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class PersonalInformationController {

    private final PersonalInformationService personalInformationService;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }


    @GetMapping("/personalinfo")
    public List<PersonalInformation> getPersonalInfo(){
        return personalInformationService.getPersonalInfo();
    }

    @GetMapping("/personalinfo/{employee_id}")
    public Optional<PersonalInformation> getEmployee(@PathVariable("employee_id") Long employee_id){
        return personalInformationService.getEmployee(employee_id);
    }


    @PostMapping("/personalinfo/post")
     public void registerNewEmployee(@RequestBody PersonalInformation employee){
        personalInformationService.addNewPersonalInfo(employee);
     }

   /* @PutMapping(path = "/personalinfo/put/{employee_id}")
    public void updateEmployee(@RequestBody PersonalInformation employee,@PathVariable("employee_id") Long id){
    personalInformationService.updateEmployee(employee, id);
    }*/

    @PutMapping(path = "/personalinfo/put/{employee_id}")
    public void  updateEmployee(@RequestBody PersonalInformation employee,@PathVariable("employee_id") Long id){
      personalInformationService.updateEmployee(employee, id);
    }


    @DeleteMapping(path = "/personalinfo/delete/{employee_id}")
    public void deleteEmployee(@PathVariable("employee_id") Long employee_id){
        personalInformationService.deleteEmployee(employee_id);
    }

    @GetMapping("/pagination")
    private APIResponse<Page<PersonalInformation>> getProductsWithPagination(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                             @RequestParam(value = "pageSize", defaultValue = "5")  int pageSize) {
        Page<PersonalInformation> productsWithPagination = personalInformationService.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<PersonalInformation>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<PersonalInformation> productsWithPagination = personalInformationService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }


    @PutMapping("/employees/put")
    public PersonalInformation updateEmployee(@RequestBody PersonalInformation employee) {
        return personalInformationRepository.save(employee);
    }

}

package com.example.demo.Service;

import com.example.demo.Entity.PersonalInformation;
import com.example.demo.Repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    @Autowired
    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }


    public List<PersonalInformation> getPersonalInfo(){

        return personalInformationRepository.findAll();

    }

    public Page<PersonalInformation> findProductsWithPagination(int offset,int pageSize){
        Page<PersonalInformation> products = personalInformationRepository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<PersonalInformation> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<PersonalInformation> products = personalInformationRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }

    public void addNewPersonalInfo(@org.jetbrains.annotations.NotNull PersonalInformation employee){
        Optional<PersonalInformation> personbyRegistrationNumber = personalInformationRepository
                .findPersonbyRegistrationNumber(employee.getEmployee_registrationNumber());
        if (personbyRegistrationNumber.isPresent()){
            throw new IllegalStateException("registration taken");
        }
        personalInformationRepository.save(employee);

        System.out.println(employee);
    }
    public void updateEmployee(PersonalInformation employee, Long employee_id){
      /*  Optional<PersonalInformation> findPersonalInformationByEmployee_id = personalInformationRepository
                .findPersonalInformationByEmployee_id(employee.getEmployee_id());
        if (!findPersonalInformationByEmployee_id.isPresent()){
            throw new IllegalStateException("id taken");
        }
        personalInformationRepository.save(employee);
        System.out.println(employee);
        */
        /*------------------------------------------------*/

        Optional<PersonalInformation> findByIdEmployee = personalInformationRepository.findById(employee_id);
        PersonalInformation personalInformation = new PersonalInformation();

        personalInformation.setEmployee_id(findByIdEmployee.get().getEmployee_id());
        personalInformation.setEmployee_name(employee.getEmployee_name());
        personalInformation.setEmployee_surname(employee.getEmployee_surname());
        personalInformation.setEmployee_department(employee.getEmployee_department());
        personalInformation.setEmployee_dateOfBirth(employee.getEmployee_dateOfBirth());
        personalInformation.setEmployee_martialStatue(employee.getEmployee_martialStatue());
        personalInformation.setEmployee_registrationNumber(employee.getEmployee_registrationNumber());
        personalInformation.setEmployee_tckn(employee.getEmployee_tckn());
        personalInformation.setEmployee_graduationstatus(employee.getEmployee_graduationstatus());
        personalInformation.setEmployee_workstatus(employee.getEmployee_workstatus());
        personalInformation.setEmployee_task(employee.getEmployee_task());

        personalInformationRepository.save(personalInformation);
        System.out.println(personalInformation);
    }



//    public PersonalInformation updateEmployee(PersonalInformation employee, Long id){
//        PersonalInformation oldPersonalInformation = null;
//
//        Optional<PersonalInformation> personbyIdNumber = personalInformationRepository
//                .findPersonalInformationByEmployee_id(employee.getEmployee_id());
//        if (personbyIdNumber.isPresent()){
//            throw new IllegalStateException("id number is not taken yet");
//        }else if(personbyIdNumber.isPresent()) {
//            oldPersonalInformation = personbyIdNumber.get();
//            BeanUtils.copyProperties(employee,oldPersonalInformation);
//            oldPersonalInformation.setEmployee_id(id);
//        }
//
//       oldPersonalInformation = personalInformationRepository.save(oldPersonalInformation);
//        return oldPersonalInformation;
//    }

//   public void updateEmployee(PersonalInformation employee, Long id){
//
//       Optional<PersonalInformation> personbyIdNumber = personalInformationRepository.findById(id);
//
//      PersonalInformation oldPersonalInformation = null;
//
//       if (!personbyIdNumber.isPresent()){
//           oldPersonalInformation = personbyIdNumber.get();
//           BeanUtils.copyProperties(employee,oldPersonalInformation);
//           oldPersonalInformation.setEmployee_id(id);
//       }
//       oldPersonalInformation = personalInformationRepository.save(oldPersonalInformation);
//       System.out.println(oldPersonalInformation);
//
//
//   }


    public void deleteEmployee(Long employee_id) {
        boolean exists =personalInformationRepository.existsById(employee_id);
        if(!exists){
            throw new IllegalStateException("Employee id:"+employee_id+" doesn't exist.");
        }
        personalInformationRepository.deleteById(employee_id);
    }

    public Optional<PersonalInformation> getEmployee(Long employee_id){
        return personalInformationRepository.findById(employee_id);


    }
}

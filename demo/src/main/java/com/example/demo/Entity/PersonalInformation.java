package com.example.demo.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class PersonalInformation {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "employee_id")
        private Long employee_id;
        @Column(name = "employee_name")
        private String employee_name;
        @Column(name = "employee_surname")
        private String employee_surname;
        @Column(name = "employee_dateofbirth")
        private LocalDate employee_dateOfBirth;
        @Enumerated(EnumType.STRING)
        @Column(name = "employee_martialstatus")
        private EmployeeMartialStatus employee_martialStatue;
        @Column(name = "employee_tckn")
        private String employee_tckn;
        @Column(name = "employee_serialnumber")
        private Integer employee_registrationNumber;
        @Enumerated(EnumType.STRING)
        @Column(name = "employee_graduatedstatus")
        private EmployeeGraduationStatus employee_graduationstatus;
        @Enumerated(EnumType.STRING)
        @Column(name = "employee_workstatus")
        private EmployeeWorkingStatus employee_workstatus;
        @Enumerated(EnumType.STRING)
        @Column(name = "employee_department")
        private EmployeeDepartmentStatus employee_department;
        @Enumerated(EnumType.STRING)
        @Column(name = "employee_task")
        private EmployeeTaskStatus employee_task;



    public PersonalInformation() {
        }


    public PersonalInformation(String employee_name,
                               String employee_surname,
                               LocalDate employee_dateOfBirth,
                               EmployeeMartialStatus employee_martialStatue,
                               String employee_tckn,
                               Integer employee_registrationNumber,
                               EmployeeGraduationStatus employee_graduationstatus,
                               EmployeeWorkingStatus employee_workstatus,
                               EmployeeDepartmentStatus employee_department,
                               EmployeeTaskStatus employee_task) {
            this.employee_name = employee_name;
            this.employee_surname = employee_surname;
            this.employee_dateOfBirth = employee_dateOfBirth;
            this.employee_martialStatue = employee_martialStatue;
            this.employee_tckn = employee_tckn;
            this.employee_registrationNumber = employee_registrationNumber;
            this.employee_graduationstatus = employee_graduationstatus;
            this.employee_workstatus = employee_workstatus;
            this.employee_department = employee_department;
            this.employee_task = employee_task;
        }

        public Long getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(Long employee_id) {
            this.employee_id = employee_id;
        }

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public String getEmployee_surname() {
            return employee_surname;
        }

        public void setEmployee_surname(String employee_surname) {
            this.employee_surname = employee_surname;
        }

        public LocalDate getEmployee_dateOfBirth() {
            return employee_dateOfBirth;
        }

        public void setEmployee_dateOfBirth(LocalDate employee_dateOfBirth) {
            this.employee_dateOfBirth = employee_dateOfBirth;
        }

        public EmployeeMartialStatus getEmployee_martialStatue() {
            return employee_martialStatue;
        }

        public void setEmployee_martialStatue(EmployeeMartialStatus employee_martialStatue) {
            this.employee_martialStatue = employee_martialStatue;
        }

        public String getEmployee_tckn() {
            return employee_tckn;
        }

        public void setEmployee_tckn(String employee_tckn) {
            this.employee_tckn = employee_tckn;
        }

        public Integer getEmployee_registrationNumber() {
            return employee_registrationNumber;
        }

        public void setEmployee_registrationNumber(Integer employee_registrationNumber) {
            this.employee_registrationNumber = employee_registrationNumber;
        }

        public EmployeeGraduationStatus getEmployee_graduationstatus() {
            return employee_graduationstatus;
        }

        public void setEmployee_graduationstatus(EmployeeGraduationStatus employee_graduationstatus) {
            this.employee_graduationstatus = employee_graduationstatus;
        }

        public EmployeeWorkingStatus getEmployee_workstatus() {
            return employee_workstatus;
        }

        public void setEmployee_workstatus(EmployeeWorkingStatus employee_workstatus) {
            this.employee_workstatus = employee_workstatus;
        }

    public EmployeeDepartmentStatus getEmployee_department() {
        return employee_department;
    }

    public void setEmployee_department(EmployeeDepartmentStatus employee_department) {
        this.employee_department = employee_department;
    }

    public EmployeeTaskStatus getEmployee_task() {
        return employee_task;
    }

    public void setEmployee_task(EmployeeTaskStatus employee_task) {
        this.employee_task = employee_task;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_surname='" + employee_surname + '\'' +
                ", employee_dateOfBirth=" + employee_dateOfBirth +
                ", employee_martialStatue=" + employee_martialStatue +
                ", employee_tckn='" + employee_tckn + '\'' +
                ", employee_registrationNumber=" + employee_registrationNumber +
                ", employee_graduationstatus=" + employee_graduationstatus +
                ", employee_workstatus=" + employee_workstatus +
                ", employee_department=" + employee_department +
                ", employee_task=" + employee_task +
                '}';
    }
}





package com.example.demo.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entryandexitinfo")
public class EntryExitInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryexit_id", unique = true, nullable = false)
    private Long entryexit_id;

    @Column(name = "entryexit_takedate")
    private LocalDate entryexit_takedate;

    @Column(name = "entryexit_backdate")
    private LocalDate entryexit_backdate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private PersonalInformation personalInformation;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private InventoryInformation inventoryInformation;


    public EntryExitInformation(Long entryexit_id, LocalDate entryexit_takedate, LocalDate entryexit_backdate,
                                PersonalInformation personalInformation, InventoryInformation inventoryInformation) {
        this.entryexit_id = entryexit_id;
        this.entryexit_takedate = entryexit_takedate;
        this.entryexit_backdate = entryexit_backdate;
        this.personalInformation = personalInformation;
        this.inventoryInformation = inventoryInformation;
    }

    public EntryExitInformation() {
    }

    public Long getEntryexit_id() {
        return entryexit_id;
    }

    public void setEntryexit_id(Long entryexit_id) {
        this.entryexit_id = entryexit_id;
    }

    public LocalDate getEntryexit_takedate() {
        return entryexit_takedate;
    }

    public void setEntryexit_takedate(LocalDate entryexit_takedate) {
        this.entryexit_takedate = entryexit_takedate;
    }

    public LocalDate getEntryexit_backdate() {
        return entryexit_backdate;
    }

    public void setEntryexit_backdate(LocalDate entryexit_backdate) {
        this.entryexit_backdate = entryexit_backdate;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public InventoryInformation getInventoryInformation() {
        return inventoryInformation;
    }

    public void setInventoryInformation(InventoryInformation inventoryInformation) {
        this.inventoryInformation = inventoryInformation;
    }

    @Override
    public String toString() {
        return "EntryExitInformation{" +
                "entryexit_id=" + entryexit_id +
                ", entryexit_takedate=" + entryexit_takedate +
                ", entryexit_backdate=" + entryexit_backdate +
                ", personalInformation=" + personalInformation +
                ", inventoryInformation=" + inventoryInformation +
                '}';
    }
}

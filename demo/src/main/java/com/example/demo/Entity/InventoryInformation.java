package com.example.demo.Entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "inventoryinformation")
public class InventoryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", unique = true, nullable = false)
    private Long inventory_id;
    @Column(name = "inventory_type")
    private String inventory_type;
    @Column(name = "inventory_entrancedate")
    private LocalDate inventory_entrancedate;
    @Column(name = "inventory_date")
    private LocalDate inventory_date;
    @Column(name = "inventory_model")
    private String inventory_model;
    @Column(name = "inventory_serialnumber")
    private Integer inventory_serialnumber;
    @Column(name = "inventory_statue")
    private String inventory_statue;

    public InventoryInformation(Long inventory_id, String inventory_type, LocalDate inventory_entrancedate,
                                LocalDate inventory_date, String inventory_model, Integer inventory_serialnumber,
                                String inventory_statue) {
        this.inventory_id = inventory_id;
        this.inventory_type = inventory_type;
        this.inventory_entrancedate = inventory_entrancedate;
        this.inventory_date = inventory_date;
        this.inventory_model = inventory_model;
        this.inventory_serialnumber = inventory_serialnumber;
        this.inventory_statue = inventory_statue;
    }

    public InventoryInformation(String inventory_type, LocalDate inventory_entrancedate, LocalDate inventory_date,
                                String inventory_model, Integer inventory_serialnumber, String inventory_statue) {
        this.inventory_type = inventory_type;
        this.inventory_entrancedate = inventory_entrancedate;
        this.inventory_date = inventory_date;
        this.inventory_model = inventory_model;
        this.inventory_serialnumber = inventory_serialnumber;
        this.inventory_statue = inventory_statue;
    }

    public InventoryInformation() {

    }

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String inventory_type) {
        this.inventory_type = inventory_type;
    }

    public LocalDate getInventory_entrancedate() {
        return inventory_entrancedate;
    }

    public void setInventory_entrancedate(LocalDate inventory_entrancedate) {
        this.inventory_entrancedate = inventory_entrancedate;
    }

    public LocalDate getInventory_date() {
        return inventory_date;
    }

    public void setInventory_date(LocalDate inventory_date) {
        this.inventory_date = inventory_date;
    }

    public String getInventory_model() {
        return inventory_model;
    }

    public void setInventory_model(String inventory_model) {
        this.inventory_model = inventory_model;
    }

    public Integer getInventory_serialnumber() {
        return inventory_serialnumber;
    }

    public void setInventory_serialnumber(Integer inventory_serialnumber) {
        this.inventory_serialnumber = inventory_serialnumber;
    }

    public String getInventory_statue() {
        return inventory_statue;
    }

    public void setInventory_statue(String inventory_statue) {
        this.inventory_statue = inventory_statue;
    }

    @Override
    public String toString() {
        return "InventoryInformation{" +
                "inventory_id=" + inventory_id +
                ", inventory_type='" + inventory_type + '\'' +
                ", inventory_entrancedate='" + inventory_entrancedate + '\'' +
                ", inventory_date=" + inventory_date +
                ", inventory_model='" + inventory_model + '\'' +
                ", inventory_serialnumber='" + inventory_serialnumber + '\'' +
                ", inventory_statue='" + inventory_statue + '\'' +
                '}';
    }
}

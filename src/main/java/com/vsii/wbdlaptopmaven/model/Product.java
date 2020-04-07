package com.vsii.wbdlaptopmaven.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String name;

    @Lob
    private String cpu;

    private String ram;

    private Double price;

    @Lob
    private String description;

    private Boolean isUpdate;

    public Product() {
    }

    public Product(String name, String cpu, String ram, Double price, String description, Boolean isUpdate) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.price = price;
        this.description = description;
        this.isUpdate = isUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUpdate() {
        return isUpdate;
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }
}

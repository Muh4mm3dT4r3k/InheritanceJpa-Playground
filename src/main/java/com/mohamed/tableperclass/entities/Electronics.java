package com.mohamed.tableperclass.entities;

import jakarta.persistence.Entity;

@Entity
public class Electronics extends Product{
    private String brand;
    private int warrantyYears;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    public void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyYears=" + warrantyYears +
                "} " + super.toString();
    }
}

package com.mohamed.joined.entities;

import jakarta.persistence.Entity;

@Entity
public class Engineer extends Employee{
    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "specialty='" + specialty + '\'' +
                "} " + super.toString();
    }
}

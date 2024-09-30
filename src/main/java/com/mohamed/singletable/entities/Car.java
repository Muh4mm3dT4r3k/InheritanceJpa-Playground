package com.mohamed.singletable.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "Car")
public class Car extends Vehicle{
    private int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfDoors=" + numberOfDoors +
                '}';
    }
}

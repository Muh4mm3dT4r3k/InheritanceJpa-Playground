package com.mohamed.joined.entities;

import jakarta.persistence.Entity;

@Entity
public class Manager extends Employee{
    private int numberOfTeams;

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "numberOfTeams=" + numberOfTeams +
                "} " + super.toString();
    }
}

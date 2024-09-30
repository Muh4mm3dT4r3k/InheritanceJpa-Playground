package com.mohamed.singletable.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "Motorbike")
public class Motorbike extends Vehicle{
    private boolean hasSidecar;

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "hasSidecar=" + hasSidecar +
                '}';
    }
}

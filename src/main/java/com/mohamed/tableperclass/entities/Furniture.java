package com.mohamed.tableperclass.entities;

import jakarta.persistence.Entity;

@Entity
public class Furniture extends Product{
    private String material;
    private String dimensions;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "material='" + material + '\'' +
                ", dimensions='" + dimensions + '\'' +
                "} " + super.toString();
    }
}

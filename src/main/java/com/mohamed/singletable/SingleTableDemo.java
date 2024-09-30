package com.mohamed.singletable;

import com.mohamed.Main;
import com.mohamed.singletable.entities.Car;
import com.mohamed.singletable.entities.Motorbike;
import jakarta.persistence.EntityManager;

public class SingleTableDemo {
    public static void main(String[] args) throws InterruptedException {

        EntityManager em = Main.getEntityManager();
        try {
            em.getTransaction().begin();
            Car car = new Car();
            car.setId(1L);
            car.setMake("make");
            car.setNumberOfDoors(4);
            car.setModel("model");

            Motorbike motorbike = new Motorbike();
            motorbike.setId(2L);
            motorbike.setMake("make");
            motorbike.setModel("model");
            motorbike.setHasSidecar(true);

            em.merge(motorbike);
            em.merge(car);
            Main.printDatabaseTables(em);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }

}

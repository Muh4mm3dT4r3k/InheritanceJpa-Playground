package com.mohamed.singletable;

import com.mohamed.Main;
import com.mohamed.persistence.CustomPersistenceUnit;
import com.mohamed.singletable.entities.Car;
import com.mohamed.singletable.entities.Motorbike;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleTableDemo {
    public static void main(String[] args) throws InterruptedException {

        String persistenceUnitName = "persistence-unit";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnit(persistenceUnitName), props);
        EntityManager em = emf.createEntityManager();
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

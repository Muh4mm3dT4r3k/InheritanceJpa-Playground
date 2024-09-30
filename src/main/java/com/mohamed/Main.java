package com.mohamed;

import com.mohamed.persistence.CustomPersistenceUnit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
    public static void printDatabaseTables(EntityManager em) {
        List<Object[]> tables = em.createNativeQuery("SHOW TABLES").getResultList();
        System.out.println("Database Tables and Columns:");
        for (Object[] table : tables) {
            String tableName = table[0].toString();
            System.out.println("Table: " + tableName);

            List<Object[]> columns = em.createNativeQuery("SHOW COLUMNS FROM " + tableName).getResultList();
            for (Object[] column : columns) {
                String columnName = column[0].toString();
                String columnType = column[1].toString();
                System.out.println("    Column: " + columnName + " - Type: " + columnType);
            }
        }
    }
    public static EntityManager getEntityManager() {
        String persistenceUnitName = "persistence-unit";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnit(persistenceUnitName), props);
        return emf.createEntityManager();
    }
}
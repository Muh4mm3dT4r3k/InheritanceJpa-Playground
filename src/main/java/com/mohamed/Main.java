package com.mohamed;

import jakarta.persistence.EntityManager;

import java.util.List;

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
}
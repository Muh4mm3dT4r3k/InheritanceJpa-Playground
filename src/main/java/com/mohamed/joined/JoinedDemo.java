package com.mohamed.joined;

import com.mohamed.Main;
import com.mohamed.joined.entities.Employee;
import com.mohamed.joined.entities.Engineer;
import com.mohamed.joined.entities.Manager;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class JoinedDemo {
    public static void main(String[] args) {
        EntityManager em = Main.getEntityManager();

        try {
            em.getTransaction().begin();
            Manager manager = new Manager();
            manager.setId(1L);
            manager.setName("manager");
            manager.setSalary(new BigDecimal(10000));
            manager.setNumberOfTeams(4);
            em.merge(manager);

            Engineer engineer = new Engineer();
            engineer.setId(2L);
            engineer.setName("engineer not a human");
            engineer.setSpecialty("software");
            engineer.setSalary(new BigDecimal(1000000000));
            em.merge(engineer);
            em.getTransaction().commit();
            Main.printDatabaseTables(em);
            System.out.println("=============================");
            var sql = "SELECT emp FROM Employee emp";
            em.createQuery(sql, Employee.class)
                    .getResultList()
                    .forEach(System.out::println);

        }finally {
            em.close();
        }
    }
}

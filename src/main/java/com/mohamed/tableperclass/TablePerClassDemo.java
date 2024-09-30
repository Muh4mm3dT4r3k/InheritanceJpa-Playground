package com.mohamed.tableperclass;

import com.mohamed.Main;
import jakarta.persistence.EntityManager;

public class TablePerClassDemo {
    public static void main(String[] args) {
        EntityManager em = Main.getEntityManager();
        try {

        }finally {
            em.close();
        }
    }
}

package org.example.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hospitalPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
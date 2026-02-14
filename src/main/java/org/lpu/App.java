package org.lpu;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lpu.Product;

public class App {

    public static SessionFactory getSessionFactory() {

        return new Configuration()
                .configure()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }
}


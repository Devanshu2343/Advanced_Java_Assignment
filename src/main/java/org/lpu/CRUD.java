package org.lpu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lpu.App;
import org.lpu.Product;

import java.util.List;

public class CRUD {

    public static void main(String[] args) {

        SessionFactory factory = App.getSessionFactory();
        Session session = factory.openSession();

        // create
        Transaction t = session.beginTransaction();

        Product product = new Product(
                "Laptop",
                "MacBook Pro M3",
                "Electronics",
                8,
                165000.0,
                "No Discount",
                true
        );

        Product product1 = new Product(
                "Accessory",
                "Mechanical Keyboard",
                "Electronics",
                25,
                4999.0,
                "10% Discount",
                true
        );


        session.persist(product);
        session.persist(product1);
        t.commit();
        System.out.println("Product saved!");


        // Read
        t = session.beginTransaction();

        List<Product> products = session.createQuery("from Product", Product.class).list();

        for (Product p : products) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }

        t.commit();


        // Update
        t = session.beginTransaction();

        Product updateProduct = session.get(Product.class, 1L);
        updateProduct.setPrice(70000.0);

        t.commit();
        System.out.println("Product updated!");


        // Delete
        t = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 1L);
        session.remove(deleteProduct);

        t.commit();
        System.out.println("Product deleted!");


        session.close();
        factory.close();
    }
}

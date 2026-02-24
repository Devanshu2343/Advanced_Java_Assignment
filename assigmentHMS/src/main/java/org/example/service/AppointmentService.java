package org.example.service;

import org.example.entity.Appointment;
import org.example.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AppointmentService {

    public void save(Appointment appointment) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(appointment);
        tx.commit();

        em.close();
    }

    public Appointment findById(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Appointment appointment = em.find(Appointment.class, id);
        em.close();
        return appointment;
    }

    public List<Appointment> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Appointment> list =
                em.createQuery("SELECT a FROM Appointment a", Appointment.class)
                        .getResultList();
        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Appointment appointment = em.find(Appointment.class, id);
        if (appointment != null) {
            em.remove(appointment);
        }
        tx.commit();

        em.close();
    }
}
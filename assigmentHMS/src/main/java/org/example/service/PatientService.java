package org.example.service;

import org.example.entity.Patient;
import org.example.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PatientService {

    public void save(Patient patient) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(patient);
        tx.commit();

        em.close();
    }

    public Patient findById(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    public List<Patient> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Patient> list =
                em.createQuery("SELECT p FROM Patient p", Patient.class)
                        .getResultList();
        em.close();
        return list;
    }

    public void update(Patient patient) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(patient);
        tx.commit();

        em.close();
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        }
        tx.commit();

        em.close();
    }
}
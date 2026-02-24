package org.example.service;

import org.example.entity.Department;
import org.example.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class DepartmentService {

    public void save(Department department) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(department);
        tx.commit();

        em.close();
    }

    public Department findById(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Department dept = em.find(Department.class, id);
        em.close();
        return dept;
    }

    public List<Department> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Department> list =
                em.createQuery("SELECT d FROM Department d", Department.class)
                        .getResultList();
        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Department dept = em.find(Department.class, id);
        if (dept != null) {
            em.remove(dept);
        }
        tx.commit();

        em.close();
    }
}
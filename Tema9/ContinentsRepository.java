package Repositories;

import Elements.Manager;
import Entity.CityEntity;
import Entity.ContinentsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import java.util.List;

public class ContinentsRepository {

    private static EntityManager entityManager;

    public static void createContinents(ContinentsEntity city) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static ContinentsEntity findById(int id) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ContinentsEntity continents = entityManager.find(ContinentsEntity.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return continents;
    }

//    public static List<ContinentsEntity> findByName(String name) {
//        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
//
//        entityManager.getTransaction().begin();
//        Query q = entityManager.createNamedQuery("ContinentsEntity.findByName").setParameter("name", name);
//        entityManager.getTransaction().commit();
//
//        List<ContinentsEntity> continentsEntities = q.getResultList();
//
//        entityManager.close();
//
//        return continentsEntities;
//    }
}

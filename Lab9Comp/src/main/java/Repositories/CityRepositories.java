package Repositories;

import Elements.Manager;
import Entity.CityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CityRepositories {

    private static EntityManager entityManager;

    public static void createCity(CityEntity city) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static CityEntity findById(int id) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CityEntity city = entityManager.find(CityEntity.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

//    public static List<CityEntity> findByName(String name) {
//        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
//
//        entityManager.getTransaction().begin();
//        Query q = entityManager.createNamedQuery("CityEntity.findByName").setParameter("name", name);
//        entityManager.getTransaction().commit();
//
//        List<CityEntity> cityEntities = q.getResultList();
//
//        entityManager.close();
//
//        return cityEntities;
//    }
}

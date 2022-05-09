package Repositories;

import Elements.Manager;
import Entity.CityEntity;
import Entity.CountryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import java.util.List;

public class CountryRepositories {

    private static EntityManager entityManager;

    public static void createCountry(CountryEntity country) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static CountryEntity findById(int id) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CountryEntity country = entityManager.find(CountryEntity.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country;
    }

    public static List<CountryEntity> findByName(String name) {
        EntityManager entityManager = Manager.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        Query q = entityManager.createNamedQuery("CountryEntity.findByName").setParameter("name", name);
        entityManager.getTransaction().commit();

        List<CountryEntity> countryEntities = q.getResultList();

        entityManager.close();

        return countryEntities;
    }
}

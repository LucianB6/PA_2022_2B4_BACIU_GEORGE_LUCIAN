package Elements;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager{
    private static EntityManagerFactory entityManagerFactory;

    private Manager() {}

    public static void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Lab9Comp");
    }

    public static void end(){
        entityManagerFactory.close();
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}

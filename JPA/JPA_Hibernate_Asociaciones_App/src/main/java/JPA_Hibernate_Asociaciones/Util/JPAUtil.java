package JPA_Hibernate_Asociaciones.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
        //Atributos de JPAUtil
    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    //Constructores de JPAUtil
    //Asignadores de atributos de JPAUtil (setters)
        //Lectores de atributos de JPAUtil (getters)
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

        //Métodos de JPAUtil
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("EjemploJPAAsociaciones");
    }
}

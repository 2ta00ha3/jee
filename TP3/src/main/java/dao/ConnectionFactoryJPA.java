package dao;

import javax.persistence.*;

public class ConnectionFactoryJPA {
    private static EntityManagerFactory emf = null;

    private ConnectionFactoryJPA() {}

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("MyPU");
        }
        return emf.createEntityManager();
    }
}

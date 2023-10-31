package auction.com.server.services;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaService {

    private static JpaService instance;
    private EntityManagerFactory emf ;

    private JpaService(){
        emf = Persistence.createEntityManagerFactory("testEntityManagerFactory");
    }

    public static synchronized JpaService getInstance() {
        return instance == null ? instance = new JpaService() : instance;
    }

    public void shutdown(){
        if(emf != null)
            emf.close();
    }

    public EntityManagerFactory entityManagerFactory(){
        return emf;
    }
}

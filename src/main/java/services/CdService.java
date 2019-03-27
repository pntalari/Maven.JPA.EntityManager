package services;

import entities.ArtistEntity;
import entities.CdEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class CdService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    public void createCD(int id, Set<ArtistEntity> artist, String description,
                         float price,String title, int year){


    }

}

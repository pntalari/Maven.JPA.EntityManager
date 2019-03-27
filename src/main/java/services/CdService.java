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

    public CdEntity createCD(int id, String description,
                         float price,String title, int year,Set<ArtistEntity> artists){
        {
            CdEntity cdEntity = new CdEntity();

            cdEntity.setId(id);
            cdEntity.setDescription(description);
            cdEntity.setPrice(price);
            cdEntity.setTitle(title);
            cdEntity.setArtists(artists);

            entityTransaction.begin();
            entityManager.persist(cdEntity);
            entityTransaction.commit();

            return cdEntity;

        }
    }

}

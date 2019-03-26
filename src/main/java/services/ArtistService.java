package services;

import entities.ArtistEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ArtistService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
    private EntityManager entityManager = emf.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public ArtistEntity createArtist(Integer id, String firstName, String lastName, String instrument){
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(id);
        artistEntity.setFirstName(firstName);
        artistEntity.setLastName(lastName);
        artistEntity.setInstrument(instrument);

        entityTransaction.begin();
        entityManager.persist(artistEntity);
        entityTransaction.commit();

        return artistEntity;
    }

    public ArtistEntity findArtistById(Integer id){
        return entityManager.find(ArtistEntity.class,id);
    }

}

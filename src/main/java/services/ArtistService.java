package services;

import entities.ArtistEntity;

import javax.persistence.*;
import java.util.List;

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

    public <T> List<T> findAll(){
        Query query = entityManager.createQuery("Select e from ArtistEntity e");
        return query.getResultList();
    }

    public ArtistEntity updateArtistInstrument(ArtistEntity artist, String instrument){
        ArtistEntity artistToBeUpdated = entityManager.merge(artist);

        entityTransaction.begin();
        artistToBeUpdated.setInstrument(instrument);
        entityTransaction.commit();

        return artistToBeUpdated;
    }

    public void deleteArtist(ArtistEntity artist){
        ArtistEntity artistToBeDeleted = entityManager.merge(artist);

        entityTransaction.begin();
        entityManager.remove(artistToBeDeleted);
        entityTransaction.commit();

     //   return artistToBeDeleted;
    }


}

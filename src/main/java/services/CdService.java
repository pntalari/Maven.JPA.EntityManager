package services;

import entities.ArtistEntity;
import entities.CdEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class CdService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    
    /** Create CD **/
    public CdEntity createCD(String description,
                         float price,String title, int year,Set<ArtistEntity> artists){

            CdEntity cdEntity = new CdEntity();

            cdEntity.setDescription(description);
            cdEntity.setPrice(price);
            cdEntity.setTitle(title);
            cdEntity.setArtists(artists);
            cdEntity.setYear(year);

            entityTransaction.begin();
            entityManager.persist(cdEntity);
            entityTransaction.commit();

            return cdEntity;

    }

    /** Find the CD by cdId **/
    public CdEntity findCdById (Integer id) {
        return entityManager.find(CdEntity.class, id);
    }

    /** findAll() **/
    public <T>List<T> findAllCds(){
        Query query = entityManager.createQuery("Select e from CdEntity e");
        return query.getResultList();
    }

    /** Update CD data **/
    public CdEntity updateCdTitle(CdEntity cd, String title) {
        CdEntity cdEntity = entityManager.merge(cd);

        entityTransaction.begin();
        cdEntity.setTitle(title);
        entityTransaction.commit();

        return cdEntity;
    }

    /** Delete a CD **/
    public void deleteCd(CdEntity cd){
        CdEntity cdToBeDeleted = entityManager.merge(cd);
        entityTransaction.begin();
        entityManager.remove(cdToBeDeleted);
        entityTransaction.commit();
    }

}

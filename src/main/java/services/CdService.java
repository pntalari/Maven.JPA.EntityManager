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
    public CdEntity createCD(int id, String description,
                         float price,String title, int year,Set<ArtistEntity> artists){

            CdEntity cdEntity = new CdEntity();

            cdEntity.setId(id);
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
//    update()
//    create()
//    delete()


}

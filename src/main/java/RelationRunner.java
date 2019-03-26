import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RelationRunner {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
    EntityManager em = emf.createEntityManager();
    EntityTransaction etxn = em.getTransaction();


}

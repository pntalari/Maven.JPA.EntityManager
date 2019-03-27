import entities.ArtistEntity;
import entities.CdEntity;
import services.CdService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class RelationRunner {

    public static void main(String... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etxn = em.getTransaction();

        CdService cdService = new CdService();
        Set<ArtistEntity> artistEntitySet1 = new HashSet<>();
        Set<ArtistEntity> artistEntitySet2 = new HashSet<>();

        artistEntitySet1.add(new ArtistEntity(8, "Joe", "Arnone", "Keyboard"));
        artistEntitySet2.add(new ArtistEntity(9, "Sal", "Giafaglone", "Xailophone"));
        artistEntitySet1.add(new ArtistEntity(10, "Jidh", "Mohan", "Chelo"));
        artistEntitySet2.add(new ArtistEntity(11, "Lucas", "Turpin", "Saxophone"));

        CdEntity cd1 = cdService.createCD(1, "Spring Music", 150, "Spring", 2019, artistEntitySet1);
        CdEntity cd2 = cdService.createCD(2, "Fall Music", 150, "Fall", 2018, artistEntitySet2);
        CdEntity cd3 = cdService.createCD(3, "Winter Music", 150, "Winter", 2017, artistEntitySet1);
        CdEntity cd4 = cdService.createCD(4, "Summer Music", 150, "Summar", 2016, artistEntitySet2);

        for (int i = 0; i < artistEntitySet1.size(); i++) {
            System.out.println("CD: " +cd1 + ",Artists on the CD: " +cd1.getArtists());
            System.out.println("CD: " +cd2 + ",Artists on the CD: " +cd2.getArtists());
        }

        for (int i = 0; i < artistEntitySet2.size(); i++) {
            System.out.println("CD: " +cd1 + ",Artists on the CD: " +cd1.getArtists());
            System.out.println("CD: " +cd2 + ",Artists on the CD: " +cd2.getArtists());
        }

    }

}

import entities.ArtistEntity;
import entities.CdEntity;
import services.ArtistService;
import services.CdService;

import java.util.*;

public class MainRunner {
    public static void main(String... args) {

        /** Artist Entity service **/
        ArtistService artistService = new ArtistService();
        ArtistEntity artistEntity = new ArtistEntity();
        Set<ArtistEntity> artistSet1 = new HashSet<>();


        /**Create Artist**/
//         artistEntity = artistService.createArtist(6,"Elton", "John","Piano");
//         artistService.createArtist(2,"Britney", "Spears","Base");

        artistSet1.add(new ArtistEntity(8, "Joe", "Arnone", "Keyboard"));
        artistSet1.add(new ArtistEntity(9, "Jidh", "Mohan", "Chelo"));
//
//         System.out.println("Artist Persisted: " + artistEntity.getId());

        /** find artist by Id **/
      //  artistEntity = artistService.findArtistById(2);
      //  System.out.println("Finding Artist: " + artistEntity);

        /** Update artist **/
//        artistEntity = artistService.updateArtistInstrument(artistEntity,"Jazz");
//        System.out.println("Artist Updated: " +artistEntity);

        /** delete artist **/
     //   artistService.deleteArtist(artistEntity);

        /** find all artists **/
//        List<ArtistEntity> artistList = new ArrayList<ArtistEntity>();
//        artistList = artistService.findAll();
//
//        for (int i = 0; i < artistList.size(); i++) {
//            System.out.println(artistList.get(i));
//        }

        /** CD Entity Service **/
        CdService cdService = new CdService();
        CdEntity cds = new CdEntity();
        //cdService.createCD(8, "Desert Rose", 150, "Rose", 2000,artistSet1);

        cds = cdService.findCdById(1);
        System.out.println("Finding CD: " +cds);

    }
}

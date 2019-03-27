import entities.ArtistEntity;
import entities.CdEntity;
import services.ArtistService;
import services.CdService;

import java.util.*;

public class MainRunner {
    public static void main(String... args) {

        /** Artist Entity service **/
   //     ArtistService artistService = new ArtistService();

     //   ArtistEntity artistEntity = new ArtistEntity();
        /**Create Artist**/
//         artistEntity = artistService.createArtist(6,"Elton", "John","Piano");
//         artistService.createArtist(2,"Britney", "Spears","Base");
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
//        CdService cdService = new CdService();
//        CdEntity cd;
//
//        Set<ArtistEntity> artistsSet = new HashSet<ArtistEntity>(artistList);
//        cd = cdService.createCD(1, "Desert Rose", 150, "Rose", 2000, artistsSet);
//        for (int i = 0; i < artistsSet.size(); i++) {
//            System.out.println(cd);
//        }

    }
}

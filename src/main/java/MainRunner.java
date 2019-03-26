import entities.ArtistEntity;
import services.ArtistService;

import java.util.TimeZone;

public class MainRunner {
    public static void main(String... args){
   //     System.out.println(TimeZone.getDefault());

        ArtistService artistService = new ArtistService();

        ArtistEntity artistEntity = new ArtistEntity();
         //    artistEntity = artistService.createArtist(6,"Elton", "John","Piano");

      //  artistService.createArtist(3,"Jennifer", "Lopez","Guitar");

        System.out.println("Artist Persisted: " +artistEntity.getId());

        artistEntity = artistService.findArtistById(3);
        System.out.println("Finding Artist: " + artistEntity);
    }
}

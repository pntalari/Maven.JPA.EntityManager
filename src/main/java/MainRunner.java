import entities.ArtistEntity;
import services.ArtistService;

import java.util.TimeZone;

public class MainRunner {
    public static void main(String... args){
   //     System.out.println(TimeZone.getDefault());


        ArtistService artistService = new ArtistService();

        ArtistEntity artistEntity = new ArtistEntity();


        System.out.println("Artist Persisted: " +artistEntity.getId());

        System.out.println("Finding Artist: " +artistService.findArtistById(5));
    }
}

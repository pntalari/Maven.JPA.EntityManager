package services;

import entities.ArtistEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArtistServiceTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-Entity");
    ArtistService artistService = new ArtistService();

    @Before
    public void setUp() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
    }

    @Test
    public void findArtistById() {
        //Given
        int expectedId = 5;
        String expectedFName = "Jagan";
        String expectedLName = "Mohan";
        //When
        ArtistEntity artist = artistService.findArtistById(expectedId);
        //Then
        Assert.assertEquals(expectedFName, artist.getFirstName());
        Assert.assertEquals(expectedLName, artist.getLastName());
        System.out.println("Finding Artist: " + artist);
    }

    @Test
    public void createArtist() {
        //Given
        int id = 5;
        String fName = "Jagan";
        String lName = "Mohan";
        String instrument = "Flute";
        //When
        ArtistEntity artist = artistService.createArtist(id, fName, lName, instrument);
        //Then
        ArtistEntity actualArtist = artistService.findArtistById(id);
        int actualID = actualArtist.getId();
        String actualFName = actualArtist.getFirstName();

        Assert.assertEquals(id, actualID);
        Assert.assertEquals(fName, actualFName);

        System.out.println("Artist Persisted: " + artist.getId());

    }

    @Test
    public void findAllArtists() {
        //Given
        List<ArtistEntity> artistList;
        //When
        artistList = artistService.findAll();
        //Then
        Assert.assertNotNull(artistList);
    }

    @Test
    public void updateArtistInstrument() {
        //Given
        ArtistEntity artist = artistService.findArtistById(2);
        String updatedInstrument = "Dance";
        //When
        artist = artistService.updateArtistInstrument(artist, updatedInstrument);
        //Then
        Assert.assertEquals(artist.getInstrument(), updatedInstrument);
        System.out.println("Artist Updated: " + artist);
    }

    @Test
    public void deleteArtist() {
        //Given
        int toDeleteId = 5;
        ArtistEntity artist = artistService.findArtistById(toDeleteId);
        //When
        artistService.deleteArtist(artist);
        //Then
        Assert.assertNull(artistService.findArtistById(toDeleteId));

    }


}
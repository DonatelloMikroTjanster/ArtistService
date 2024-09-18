package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.entities.Artist;
import org.example.edufyalbumforartist.exceptions.ResourceNotFoundException;
import org.example.edufyalbumforartist.repostitories.ArtistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;
    @InjectMocks
    private ArtistService artistService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAlbumsByArtistWhenArtistNotFoundException() {
        //Arrange
        int artistId = 1;
        when(artistRepository.findById(artistId)).thenReturn(Optional.empty());

        //Act
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> artistService.getAlbumsByArtist(artistId));

        //Assert
        assertEquals("Artist not found with ID : " + artistId, exception.getMessage());
        verify(artistRepository, times(1)).findById(artistId);
    }

    @Test
    void testGetAlbumsByArtist() {
        //Arrange
        Artist artist = new Artist();
        Integer artistId = 1;
        artist.setId(artistId);

        Set<Album> albums = new HashSet<>();
        Album album1 = new Album();
        Album album2 = new Album();
        albums.add(album1);
        albums.add(album2);
        artist.setAlbums(albums);

        when(artistRepository.findById(1)).thenReturn(Optional.of(artist));

        //Act
        Set<Album> result = artistService.getAlbumsByArtist(artistId);

        //Assert
        assertEquals(2, result.size());
        verify(artistRepository, times(1)).findById(artistId);

    }

    @Test
    void testAddNewArtist() {
        //Arrange
        Artist artist = new Artist();
        when(artistRepository.save(artist)).thenReturn(artist);

        //Act
        Artist result = artistService.addNewArtist(artist);

        //Assert
        assertEquals(artist, result);
        verify(artistRepository, times(1)).save(artist);
    }

    @Test
    void testGetAllArtists() {
        //Arrange
        List<Artist> artists = new ArrayList();
        Artist artist1 = new Artist();
        Artist artist2 = new Artist();
        artists.add(artist1);
        artists.add(artist2);

        when(artistRepository.findAll()).thenReturn(artists);

        //Act
        List<Artist> result = artistService.getAllArtists();

        //Assert
        assertEquals(artists, result);
        verify(artistRepository, times(1)).findAll();
    }

    @Test
    void testDeleteArtistByIdArtistNotFoundException() {
        //Arrange
        int artistId = 1;
        when(artistRepository.findById(artistId)).thenReturn(Optional.empty());

        //Act
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> artistService.getAlbumsByArtist(artistId));

        //Assert
        assertEquals("Artist not found with ID : " + artistId, exception.getMessage());
        verify(artistRepository, times(1)).findById(artistId);
    }

    @Test
    void testDeleteArtistById() {
        //Arrange
        int artistId = 1;
        Artist artist = new Artist();
        artist.setId(artistId);

        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));

        //Act
        artistService.deleteArtistById(artistId);

        //Assert
        verify(artistRepository, times(1)).findById(artistId);
        verify(artistRepository, times(1)).deleteById(artistId);
    }

    @Test
    void testUpdateArtistWithArtistNotFoundException() {
        //Arrange
        int artistId = 1;
        when(artistRepository.findById(artistId)).thenReturn(Optional.empty());

        //Act
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> artistService.getAlbumsByArtist(artistId));

        //Assert
        assertEquals("Artist not found with ID : " + artistId, exception.getMessage());
        verify(artistRepository, times(1)).findById(artistId);
    }

    @Test
    void testUpdateArtist() {
        //Arrange
        int artistId = 1;
        Artist existingArtist = new Artist();
        existingArtist.setId(artistId);
        existingArtist.setName("Artist to be updated");

        Artist updatedArtist = new Artist();
        updatedArtist.setName("Updated Artist");

        when(artistRepository.findById(artistId)).thenReturn(Optional.of(existingArtist));
        when(artistRepository.save(any(Artist.class))).thenReturn(existingArtist);

        //Act
        Artist result = artistService.updateArtist(artistId, updatedArtist);

        //Assert
        assertEquals("Updated Artist", result.getName());
        verify(artistRepository, times(1)).findById(artistId);
        verify(artistRepository, times(1)).save(existingArtist);
    }
}
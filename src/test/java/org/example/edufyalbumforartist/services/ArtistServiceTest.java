package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.repostitories.ArtistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArtistServiceTest {

    ArtistRepository artistRepository;
    ArtistService artistService;
    @BeforeEach
    void setUp() {
        artistRepository = mock(ArtistRepository.class);
        artistService = new ArtistService();
    }

    @Test
    void getAlbumsByArtist() {
    }

    @Test
    void testAddStudent() {
    }

    @Test
    void getAllArtists() {
    }

    @Test
    void deleteArtistById() {
    }

    @Test
    void updateArtist() {
    }
}
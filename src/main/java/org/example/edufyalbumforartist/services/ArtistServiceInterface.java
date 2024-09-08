package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.entities.Artist;

import java.util.List;

public interface ArtistServiceInterface {

    Artist addNewArtist(Artist artist);

    List<Artist> getAllArtists();

    void deleteArtistById(Integer artistId);

    Artist updateArtist(Integer artistId, Artist artist);

}

package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.entities.Artist;

import java.util.List;
import java.util.Set;

public interface ArtistServiceInterface {

    Artist addNewArtist(Artist artist);

    List<Artist> getAllArtists();

    void deleteArtistById(Long artistId);

    Artist updateArtist(Long artistId, Artist artist);

    Set<Album> getAlbumsByArtist(Long artistId);


}

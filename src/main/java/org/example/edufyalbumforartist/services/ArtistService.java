package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.entities.Artist;
import org.example.edufyalbumforartist.exceptions.ResourceNotFoundException;
import org.example.edufyalbumforartist.repostitories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService implements ArtistServiceInterface{

    @Autowired
    private ArtistRepository artistRepository;

    public Artist addNewArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public void deleteArtistById(Integer artistId) {
        artistRepository.findById(artistId).
                orElseThrow(() -> new ResourceNotFoundException("Artist", "ID", artistId));
        artistRepository.deleteById(artistId);
    }

    public Artist updateArtist(Integer artistId, Artist artist) {
        Artist updatedArtist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist", "ID", artistId));
        if (artist.getName() != null) {
            updatedArtist.setName(artist.getName());
        }
        return artistRepository.save(updatedArtist);
    }


}

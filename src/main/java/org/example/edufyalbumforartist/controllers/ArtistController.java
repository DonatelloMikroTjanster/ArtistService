package org.example.edufyalbumforartist.controllers;


import org.example.edufyalbumforartist.entities.Artist;
import org.example.edufyalbumforartist.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/add")
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.addNewArtist(artist));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }



    @DeleteMapping("/delete-artist/{artistId}")
    public String deleteArtist(@PathVariable Long artistId) {
        Artist artist = artistService.getAllArtists().stream()
                .filter(a -> a.getId().equals(artistId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        artistService.deleteArtistById(artistId);
        return artist.getName() + " has been deleted.";
    }

    @PutMapping("/update-artist/{artistId}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long artistId, @RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.updateArtist(artistId, artist));
    }


}

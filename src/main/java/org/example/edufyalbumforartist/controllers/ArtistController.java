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
    public String deleteArtist(@PathVariable Integer artistId) {
        Artist artist = artistService.getAllArtists().get(artistId - 1);
        artistService.deleteArtistById(artistId);
        return artist.getName() + " has been deleted.";
    }

    @PutMapping("/update-artist/{artistId}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Integer artistId, @RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.updateArtist(artistId, artist));
    }


}

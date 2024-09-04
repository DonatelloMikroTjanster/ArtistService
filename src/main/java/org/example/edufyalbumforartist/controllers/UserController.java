package org.example.edufyalbumforartist.controllers;


import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.entities.Artist;
import org.example.edufyalbumforartist.services.AlbumService;
import org.example.edufyalbumforartist.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albumbyartist")
public class UserController {

    @Autowired
    private ArtistService artistService;
    @GetMapping("/albums/{artistId}")
    public ResponseEntity<List<Album>> getAlbumsByArtist(@PathVariable Integer artistId) {
        return ResponseEntity.ok(artistService.getAlbumsByArtist(artistId));
    }
}

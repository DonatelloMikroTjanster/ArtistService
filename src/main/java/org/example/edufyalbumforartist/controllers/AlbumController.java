package org.example.edufyalbumforartist.controllers;

import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/add")
    public ResponseEntity<Album> addAlbum (@RequestBody Album album) {
        return ResponseEntity.ok(albumService.addNewAlbum(album));
    }

}

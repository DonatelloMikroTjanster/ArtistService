package org.example.edufyalbumforartist.services;

import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.repostitories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AlbumService implements AlbumServiceInterface{

    @Autowired
    private AlbumRepository albumRepository;
    @Override
    public Album addNewAlbum(Album album) {
        return albumRepository.save(album);
    }
}

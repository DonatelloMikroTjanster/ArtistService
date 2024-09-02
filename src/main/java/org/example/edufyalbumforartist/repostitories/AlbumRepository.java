package org.example.edufyalbumforartist.repostitories;

import org.example.edufyalbumforartist.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}

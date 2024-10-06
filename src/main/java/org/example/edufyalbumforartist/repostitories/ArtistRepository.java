package org.example.edufyalbumforartist.repostitories;

import org.example.edufyalbumforartist.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}

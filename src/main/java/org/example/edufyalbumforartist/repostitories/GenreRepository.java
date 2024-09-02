package org.example.edufyalbumforartist.repostitories;

import org.example.edufyalbumforartist.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}

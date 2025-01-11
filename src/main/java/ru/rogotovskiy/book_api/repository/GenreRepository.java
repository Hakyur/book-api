package ru.rogotovskiy.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rogotovskiy.book_api.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    boolean existsByName(String name);
}

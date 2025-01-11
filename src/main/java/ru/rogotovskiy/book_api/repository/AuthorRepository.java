package ru.rogotovskiy.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rogotovskiy.book_api.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

package ru.rogotovskiy.book_api.services;

import org.springframework.stereotype.Service;
import ru.rogotovskiy.book_api.dto.GenreDTO;
import ru.rogotovskiy.book_api.entity.Genre;
import ru.rogotovskiy.book_api.exceptions.DuplicateGenreException;
import ru.rogotovskiy.book_api.exceptions.GenreNotFoundException;
import ru.rogotovskiy.book_api.repository.GenreRepository;

import java.util.Collections;
import java.util.List;

@Service
public class GenreService {

    private final String GENRE_NOT_FOUND_MESSAGE = "Жанр с id = %d не найден!";
    private final String GENRE_DUPLICATE_MESSAGE = "Жанр с именем: %s уже существует!";

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElseThrow(
                () -> new GenreNotFoundException(
                        String.format(GENRE_NOT_FOUND_MESSAGE, id)
                )
        );
    }

    public GenreDTO getById(Integer id) {
        Genre genre = getGenreById(id);
        return toDTO(genre);
    }

    public void addGenre(GenreDTO genreDTO) {
        if (genreRepository.existsByName(genreDTO.name())) {
            throw new DuplicateGenreException(
                    String.format(GENRE_DUPLICATE_MESSAGE, genreDTO.name())
            );
        }
        genreRepository.save(toEntity(genreDTO));
    }

    public void deleteGenre(Integer id) {
        Genre genre = getGenreById(id);
        genreRepository.delete(genre);
    }

    public void updateGenre(Integer id, GenreDTO genreDTO) {
        Genre genre = getGenreById(id);
        genre.setName(genreDTO.name());
        genre.setDescription(genreDTO.description());
        genreRepository.save(genre);
    }

    protected Genre toEntity(GenreDTO genreDTO) {
        return new Genre(null, genreDTO.name(), genreDTO.description(), Collections.emptyList());
    }

    protected GenreDTO toDTO(Genre genre) {
        return new GenreDTO(genre.getName(), genre.getDescription());
    }
}

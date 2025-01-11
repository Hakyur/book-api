package ru.rogotovskiy.book_api.services;

import org.springframework.stereotype.Service;
import ru.rogotovskiy.book_api.dto.AuthorDTO;
import ru.rogotovskiy.book_api.entity.Author;
import ru.rogotovskiy.book_api.exceptions.AuthorNotFoundException;
import ru.rogotovskiy.book_api.repository.AuthorRepository;

import java.util.Collections;
import java.util.List;

@Service
public class AuthorService {

    private final String AUTHOR_NOT_FOUND_MESSAGE = "Автор с id = %d не найден!";

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new AuthorNotFoundException(
                        String.format(AUTHOR_NOT_FOUND_MESSAGE, id)
                )
        );
    }

    public AuthorDTO getById(Integer id) {
        Author author = getAuthorById(id);
        return toDTO(author);
    }

    public void addAuthor(AuthorDTO authorDTO) {
        authorRepository.save(toEntity(authorDTO));
    }

    public void deleteAuthor(Integer id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }

    public void updateAuthor(Integer id, AuthorDTO authorDTO) {
        Author author = getAuthorById(id);
        author.setName(authorDTO.name());
        author.setSurname(authorDTO.surname());
        author.setPatronymic(authorDTO.patronymic());
        authorRepository.save(author);
    }

    protected AuthorDTO toDTO(Author author) {
        return new AuthorDTO(author.getName(), author.getSurname(), author.getPatronymic());
    }

    protected Author toEntity(AuthorDTO authorDTO) {
        return new Author(null, authorDTO.name(), authorDTO.surname(), authorDTO.patronymic(), Collections.emptyList());
    }
}

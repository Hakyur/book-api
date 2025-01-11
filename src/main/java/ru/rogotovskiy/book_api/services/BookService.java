package ru.rogotovskiy.book_api.services;

import org.springframework.stereotype.Service;
import ru.rogotovskiy.book_api.dto.BookRequestDTO;
import ru.rogotovskiy.book_api.dto.BookResponseDTO;
import ru.rogotovskiy.book_api.entity.Book;
import ru.rogotovskiy.book_api.exceptions.BookNotFoundException;
import ru.rogotovskiy.book_api.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final String BOOK_NOT_FOUND_MESSAGE = "Книга с id = %d не найдена!";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookService(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public BookResponseDTO getById(Integer id) {
        Book book = getBookById(id);
        return toDTO(book);
    }


    public void addBook(BookRequestDTO bookDTO) {
        bookRepository.save(toEntity(bookDTO));
    }

    public void deleteBook(Integer id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    public void updateBook(Integer id, BookRequestDTO bookDTO) {
        getBookById(id);
        Book updatedBook = toEntity(bookDTO);
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException(
                        String.format(BOOK_NOT_FOUND_MESSAGE, id)
                )
        );
    }

    private BookResponseDTO toDTO(Book book) {
        return new BookResponseDTO(
                book.getTitle(),
                book.getDescription(),
                authorService.toDTO(book.getAuthor()),
                genreService.toDTO(book.getGenre())
        );
    }

    private Book toEntity(BookRequestDTO bookDTO) {
        return new Book(
                null,
                bookDTO.title(),
                bookDTO.description(),
                authorService.getAuthorById(bookDTO.authorId()),
                genreService.getGenreById(bookDTO.genreId())
        );
    }
}

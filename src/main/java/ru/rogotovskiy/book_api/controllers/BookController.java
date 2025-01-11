package ru.rogotovskiy.book_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.BookRequestDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.BookService;

@Tag(name = "Книги", description = "Контроллер для работы с книгами")
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Получить список всех книг")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @Operation(summary = "Получить конкретную книгу")
    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @Operation(summary = "Добавить новую книгу")
    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookRequestDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.ok(new SuccessResponse("Книга добавлена успешно!"));
    }

    @Operation(summary = "Удалить книгу")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new SuccessResponse("Книга удалена успешно!"));
    }

    @Operation(summary = "Обновить существующую книгу")
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestParam Integer id, @RequestBody BookRequestDTO bookDTO) {
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(new SuccessResponse("Книга успешно обновлена!"));
    }
}

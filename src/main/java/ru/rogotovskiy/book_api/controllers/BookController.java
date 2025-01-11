package ru.rogotovskiy.book_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.BookRequestDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookRequestDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.ok(new SuccessResponse("Книга добавлена успешно!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new SuccessResponse("Книга удалена успешно!"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestParam Integer id, @RequestBody BookRequestDTO bookDTO) {
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(new SuccessResponse("Книга успешно обновлена!"));
    }
}

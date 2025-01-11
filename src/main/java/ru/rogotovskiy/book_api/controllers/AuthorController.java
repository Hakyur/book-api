package ru.rogotovskiy.book_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.AuthorDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.AuthorService;

@Tag(name = "Авторы", description = "Контроллер для работы с авторами книг")
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Operation(summary = "Получить список всех авторов")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok().body(authorService.getAll());
    }

    @Operation(summary = "Получить конкретного автора")
    @GetMapping("/get")
    public ResponseEntity<?> getAuthor(@RequestParam Integer id) {
        return ResponseEntity.ok().body(authorService.getById(id));
    }

    @Operation(summary = "Добавить нового автора")
    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO) {
        authorService.addAuthor(authorDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно добавлен!"));
    }

    @Operation(summary = "Удалить автора")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@RequestParam Integer id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно удалён!"));
    }

    @Operation(summary = "Обновить существующего автора")
    @PutMapping("/update")
    public ResponseEntity<?> updateAuthor(@RequestParam Integer id, @RequestBody AuthorDTO authorDTO) {
        authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно обновлён!"));
    }
}

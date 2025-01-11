package ru.rogotovskiy.book_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.AuthorDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok().body(authorService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAuthor(@RequestParam Integer id) {
        return ResponseEntity.ok().body(authorService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO) {
        authorService.addAuthor(authorDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно добавлен!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@RequestParam Integer id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно удалён!"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAuthor(@RequestParam Integer id, @RequestBody AuthorDTO authorDTO) {
        authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Автор успешно обновлён!"));
    }
}

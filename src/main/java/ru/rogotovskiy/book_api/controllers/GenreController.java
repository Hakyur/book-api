package ru.rogotovskiy.book_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.GenreDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.GenreService;

@Tag(name = "Жанры", description = "Контроллер для работы с жанрами книг")
@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @Operation(summary = "Получить список всех жанров")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllGenres() {
        return ResponseEntity.ok(genreService.getAll());
    }

    @Operation(summary = "Получить конкретный жанр")
    @GetMapping("/get")
    public ResponseEntity<?> getGenre(@RequestParam Integer id) {
        return ResponseEntity.ok(genreService.getById(id));
    }

    @Operation(summary = "Добавить новый жанр")
    @PostMapping("/add")
    public ResponseEntity<?> addGenre(@RequestBody GenreDTO genreDTO) {
        genreService.addGenre(genreDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно добавлен!"));
    }

    @Operation(summary = "Удалить жанр")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGenre(@RequestParam Integer id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно удалён!"));
    }

    @Operation(summary = "Обновить существующий жанр")
    @PutMapping("/update")
    public ResponseEntity<?> updateGenre(@RequestParam Integer id, @RequestBody GenreDTO genreDTO) {
        genreService.updateGenre(id, genreDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно обновлён!"));
    }
}

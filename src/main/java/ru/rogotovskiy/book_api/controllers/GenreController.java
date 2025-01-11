package ru.rogotovskiy.book_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rogotovskiy.book_api.dto.GenreDTO;
import ru.rogotovskiy.book_api.dto.SuccessResponse;
import ru.rogotovskiy.book_api.services.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllGenres() {
        return ResponseEntity.ok(genreService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getGenre(@RequestParam Integer id) {
        return ResponseEntity.ok(genreService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addGenre(@RequestBody GenreDTO genreDTO) {
        genreService.addGenre(genreDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно добавлен!"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGenre(@RequestParam Integer id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно удалён!"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateGenre(@RequestParam Integer id, @RequestBody GenreDTO genreDTO) {
        genreService.updateGenre(id, genreDTO);
        return ResponseEntity.ok().body(new SuccessResponse("Жанр успешно обновлён!"));
    }
}

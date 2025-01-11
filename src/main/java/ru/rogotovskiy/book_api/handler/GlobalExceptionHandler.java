package ru.rogotovskiy.book_api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.rogotovskiy.book_api.dto.ErrorResponse;
import ru.rogotovskiy.book_api.exceptions.DuplicateGenreException;
import ru.rogotovskiy.book_api.exceptions.GenreNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenreNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGenreNotFoundException(GenreNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(toErrorResponse(e));
    }

    @ExceptionHandler(DuplicateGenreException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateGenreException(DuplicateGenreException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(toErrorResponse(e));
    }

    private ErrorResponse toErrorResponse(Exception e) {
        return new ErrorResponse(
                e.getMessage(),
                LocalDateTime.now()
        );
    }
}

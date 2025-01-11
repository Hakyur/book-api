package ru.rogotovskiy.book_api.exceptions;

public class DuplicateGenreException extends RuntimeException {
    public DuplicateGenreException(String message) {
        super(message);
    }
}

package ru.rogotovskiy.book_api.exceptions;

public class BookNotFoundException extends ObjectNotFoundException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

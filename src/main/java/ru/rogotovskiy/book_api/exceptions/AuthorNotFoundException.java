package ru.rogotovskiy.book_api.exceptions;

public class AuthorNotFoundException extends ObjectNotFoundException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}

package ru.rogotovskiy.book_api.exceptions;

public class GenreNotFoundException extends ObjectNotFoundException {
  public GenreNotFoundException(String message) {
    super(message);
  }
}

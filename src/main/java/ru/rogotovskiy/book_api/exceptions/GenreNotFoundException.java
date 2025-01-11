package ru.rogotovskiy.book_api.exceptions;

public class GenreNotFoundException extends RuntimeException {
  public GenreNotFoundException(String message) {
    super(message);
  }
}

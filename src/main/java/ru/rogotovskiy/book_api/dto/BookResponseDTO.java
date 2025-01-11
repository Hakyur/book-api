package ru.rogotovskiy.book_api.dto;

public record BookResponseDTO(
        String title,
        String description,
        AuthorDTO author,
        GenreDTO genre
) {
}

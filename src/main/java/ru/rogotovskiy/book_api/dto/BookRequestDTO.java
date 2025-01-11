package ru.rogotovskiy.book_api.dto;

public record BookRequestDTO(
        String title,
        String description,
        Integer authorId,
        Integer genreId
) {
}

package ru.rogotovskiy.book_api.dto;

public record AuthorDTO(
        String name,
        String surname,
        String patronymic
) {}

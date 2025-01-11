package ru.rogotovskiy.book_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO книги для отправки ответа от сервера")
public record BookResponseDTO(

        @Schema(description = "Название книги", example = "Война и мир")
        String title,

        @Schema(
                description = "Описание книги",
                example = "Роман-эпопея Льва Николаевича Толстого, описывающий русское " +
                        "общество в эпоху войн против Наполеона в 1805—1812 годах."
        )
        String description,

        @Schema(description = "DTO автора")
        AuthorDTO author,

        @Schema(description = "DTO жанра")
        GenreDTO genre
) {
}

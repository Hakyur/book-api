package ru.rogotovskiy.book_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO книги для запроса на сервер")
public record BookRequestDTO(

        @Schema(description = "Название книги", example = "Война и мир")
        String title,

        @Schema(
                description = "Описание книги",
                example = "Роман-эпопея Льва Николаевича Толстого, описывающий русское " +
                        "общество в эпоху войн против Наполеона в 1805—1812 годах."
        )
        String description,

        @Schema(description = "Уникальный идентификатор автора", example = "1")
        Integer authorId,

        @Schema(description = "Уникальный идентификатор жанра", example = "2")
        Integer genreId
) {
}

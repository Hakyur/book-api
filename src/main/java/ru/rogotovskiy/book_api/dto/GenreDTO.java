package ru.rogotovskiy.book_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO жанра")
public record GenreDTO (

        @Schema(description = "Наименование жанра", example = "Роман")
        String name,

        @Schema(
                description = "Описание жанра",
                example = "Обширное нарративное произведение, исследующее персонажей, " +
                        "их развитие и взаимодействие в комплексном сюжете."
        )
        String description
) {}

package ru.rogotovskiy.book_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO автора")
public record AuthorDTO(

        @Schema(description = "Имя автора", example = "Александр")
        String name,

        @Schema(description = "Фамилия автора", example = "Пушкин")
        String surname,

        @Schema(description = "Отчество автора", example = "Сергеевич")
        String patronymic
) {}

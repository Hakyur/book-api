package ru.rogotovskiy.book_api.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private LocalDateTime time;

    public ErrorResponse(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

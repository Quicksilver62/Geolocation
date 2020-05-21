package com.packt.microservices.geolocation.exceptions;

public enum Error {
    BAD_REQUEST("BAD_REQUEST", "Bad request", "Не заполнены обязательные поля или отсутствует файл"),
    INTERNAL_ERROR("INTERNAL_ERROR", "Internal error", "Внутренняя ошибка"),
    VALIDATION_ERROR("VALIDATION_ERROR", "Validation error", "Ошибка валидации"),
    USER_NOT_FOUND ("USER_NOT_FOUND", "User not found", "Польозватель не найден"),
    TRACK_NOT_FOUND ("TRACK_NOT_FOUND", "Track not found", "Номер трека не найден"),
    TYPE_MISMATCH ("TYPE_MISMATCH", "Type mismatch", "Ошибка преобразования типов"),
    MALFORMED_JSON_REQUEST("MALFORMED_JSON_REQUEST", "Malformed JSON request", "Ошибка в структуре запроса");

    private final String code;
    private final String message;
    private final String description;

    Error(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() { return message; }

    public String getDescription() {
        return description;
    }

}

package com.packt.microservices.geolocation.exceptions;

import org.springframework.http.HttpStatus;

public enum Error {
    BAD_REQUEST("BAD_REQUEST", HttpStatus.BAD_REQUEST, "Не заполнены обязательные поля или отсутствует файл"),
    INTERNAL_ERROR("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "Внутренняя ошибка"),
    VALIDATION_ERROR("VALIDATION_ERROR", HttpStatus.BAD_REQUEST, "Ошибка валидации"),
    USER_NOT_FOUND ("USER_NOT_FOUND", HttpStatus.NO_CONTENT, "Польозватель не найден"),
    TRACK_NOT_FOUND ("TRACK_NOT_FOUND", HttpStatus.NO_CONTENT, "Номер трека не найден"),
    TYPE_MISMATCH ("TYPE_MISMATCH", HttpStatus.BAD_REQUEST, "Ошибка преобразования типов"),
    MALFORMED_JSON_REQUEST("MALFORMED_JSON_REQUEST", HttpStatus.BAD_REQUEST, "Ошибка в структуре запроса");

    private final String code;
    private final HttpStatus status;
    private final String description;


    Error(String code, HttpStatus status, String description) {
        this.code = code;
        this.status = status;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

}

package com.packt.microservices.geolocation.exceptions;

import org.assertj.core.annotations.Nullable;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public abstract class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, Error.MALFORMED_JSON_REQUEST.getCode(), e);
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler ({TypeMismatchException.class})
    @Nullable
    public ResponseEntity<Object> handleTypeMismatchException (Exception e, WebRequest request) throws Exception {

        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, Error.MALFORMED_JSON_REQUEST.getCode(), e);
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

}

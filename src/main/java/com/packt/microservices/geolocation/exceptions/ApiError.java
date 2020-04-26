package com.packt.microservices.geolocation.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError extends Throwable {

    private HttpStatus status;
    private String message;
    private List<Throwable> errors;

    public ApiError(HttpStatus status, String message, List<Throwable> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, Throwable error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Throwable> getErrors() {
        return errors;
    }

    //    ApiError() {}
//
//    ApiError(HttpStatus status) {
//        this();
//        this.status = status;
//    }
//
//    ApiError(HttpStatus status, Throwable e) {
//        this();
//        this.status = status;
//        this.message = "INTERNAL_ERROR";
//    }
//
//    ApiError(HttpStatus status, String message, Throwable e) {
//        this();
//        this.status = status;
//        this.message = message;
//    }

//    public ApiError(String message) {
//        super(message);
//        this.status = status;
//        this.message = message;
//        errors = Arrays.asList(error);
//    }

//    public ApiError(HttpStatus status) {
//        super();
//        this.status = status;
////        this.message = message;
////        errors = Arrays.asList(error);
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public HttpStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(HttpStatus status) {
//        this.status = status;
//    }

}

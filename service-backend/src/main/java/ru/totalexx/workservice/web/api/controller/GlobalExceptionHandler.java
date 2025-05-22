package ru.totalexx.workservice.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.web.api.model.response.exception.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionResponse> handleServiceException(ServiceException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ExceptionResponse(ex.getMessage()));
    }
}

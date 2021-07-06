package br.com.meli.apilinktracker.apilinktracker.exception;

import br.com.meli.apilinktracker.apilinktracker.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class URLInvalidaExcepetionHandler {

    @ExceptionHandler(URLInvalidaException.class)
    public ResponseEntity<?> urlInvalidaExceptionHandler(URLInvalidaException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
    }

}

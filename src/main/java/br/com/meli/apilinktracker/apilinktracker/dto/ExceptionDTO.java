package br.com.meli.apilinktracker.apilinktracker.dto;

public class ExceptionDTO {

    private String message;

    public ExceptionDTO() {
    }

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package br.com.meli.apilinktracker.apilinktracker.exception;

public class URLInvalidaException extends RuntimeException{

    public URLInvalidaException(String msg) {
        super(msg);
    }

    public URLInvalidaException(Exception e) {
        super(e);
    }
}

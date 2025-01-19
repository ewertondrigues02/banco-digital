package br.com.ewerton.padraocamadas.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String mensagem) {
        super(mensagem);
    }

    public ValidationException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}

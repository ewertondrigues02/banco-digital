package br.com.ewerton.padraocamadas.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }

    public EntityNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

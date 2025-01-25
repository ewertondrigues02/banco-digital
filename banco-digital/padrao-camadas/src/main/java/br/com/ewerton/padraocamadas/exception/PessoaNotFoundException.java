package br.com.ewerton.padraocamadas.exception;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(String message) {
        super(message);
    }
}

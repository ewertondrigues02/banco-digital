package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;

public interface GenericService<T, ID> {

    T consultar(ID id) throws PessoaNotFoundException;

    T depositar(T entity) throws PessoaNotFoundException, ValidationException;

    T enviar(T valor) throws PessoaNotFoundException;

}

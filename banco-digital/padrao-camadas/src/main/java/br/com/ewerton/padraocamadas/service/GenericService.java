package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.exception.EntityNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;

public interface GenericService<T, ID> {

    T consultar(ID id) throws EntityNotFoundException;

    T depositar(T entity) throws EntityNotFoundException, ValidationException;

    T enviar(T valor) throws EntityNotFoundException;

}

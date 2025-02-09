package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;

import java.math.BigDecimal;
import java.time.Instant;

public interface GenericService<T, ID> {

    T consultar(ID id) throws PessoaNotFoundException;

    T depositar(T entity, BigDecimal valor) throws PessoaNotFoundException, ValidationException;

    T enviar(T entityRemetente, T entityDestino, BigDecimal valor, Instant horaTransferencia) throws PessoaNotFoundException;

}

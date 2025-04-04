package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.PessoaLojistaDto;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.Instant;

public interface GenericService<T, ID> {

    T consultar(String id) throws PessoaNotFoundException;

    T depositar(T entity, BigDecimal valor) throws PessoaNotFoundException, ValidationException;

//    <T extends Pessoa> T enviar(T entityRemetenteFisica, T entityDestinoFisica, T entityDestinoLojista, BigDecimal valor, Instant horaTransferencia) throws PessoaNotFoundException, ValidationException;

    PessoaFisicaDto enviarParaPessoaFisica(PessoaFisicaDto entityRemetenteFisica, PessoaFisicaDto entityDestinoFisica, BigDecimal valor) throws EntityNotFoundException, ValidationException;

    PessoaFisicaDto enviarParaLojista(PessoaFisicaDto entityRemetenteFisica, PessoaLojistaDto entityDestinoLojista, BigDecimal valor) throws EntityNotFoundException, ValidationException;
}

package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.exception.EntityNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisica, Long>{

    @Autowired
    private PessoaFisicaRepository pessoafisica;


    @Override
    public PessoaFisica consultar(PessoaFisica id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public PessoaFisica depositar(PessoaFisica entity) throws EntityNotFoundException, ValidationException {
        return null;
    }

    @Override
    public PessoaFisica enviar(PessoaFisica valor) throws EntityNotFoundException {
        return null;
    }
}

package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.exception.EntityNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import br.com.ewerton.padraocamadas.utils.CpfValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisica, String>{

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    private PessoaFisica pessoaFisica;

    private PessoaFisicaDto pessoaFisicaDto;


    @Override
    public PessoaFisica consultar(String cpf) throws EntityNotFoundException {
        if ( == null || cpf.isEmpty() || !CpfValidador.isValid(cpf)) {
            throw new EntityNotFoundException("CPF nulo ou vazio, favor tente novamente");
    } else if (!CpfValidador.isValid(cpf)) {
            throw new EntityNotFoundException("Insira o CPF no formato: xxx.xxx.xxx-xx");
        }
            return pessoaFisicaRepository.
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

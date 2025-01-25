package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.exception.EntityNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import br.com.ewerton.padraocamadas.utils.CpfValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisica, String> {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    private PessoaFisica pessoaFisica;

    private PessoaFisicaDto pessoaFisicaDto;


    @Override
    public PessoaFisica consultar(String cpf) throws EntityNotFoundException {
        cpf = cpf.replace(".", "").replace("-", "");
        if (cpf == null || cpf.isEmpty()) {
            throw new EntityNotFoundException("CPF nulo ou vazio, favor tente novamente.");
        }
        if (!CpfValidador.isValid(cpf)) {
            throw new EntityNotFoundException("CPF inválido. Certifique-se de que o CPF é válido e no formato correto.");
        }
        Long cpfLong;
        try {
            cpfLong = Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new EntityNotFoundException("Erro ao converter CPF para número. Verifique o formato.");
        }
        Optional<PessoaFisica> obj = pessoaFisicaRepository.findById(cpfLong);
        if (obj.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma pessoa encontrada para o CPF fornecido.");
        }
        return obj.get();
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

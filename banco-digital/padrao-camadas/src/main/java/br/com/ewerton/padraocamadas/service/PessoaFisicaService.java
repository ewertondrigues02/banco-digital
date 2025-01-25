package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import br.com.ewerton.padraocamadas.utils.CpfValidador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisicaDto, String> {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    private PessoaFisica pessoaFisica;

    private PessoaFisicaDto pessoaFisicaDto;


    @Override
    public PessoaFisicaDto consultar(String cpf) throws PessoaNotFoundException {
        if (cpf == null || cpf.isEmpty()) {
            throw new PessoaNotFoundException("CPF nulo ou vazio, favor tente novamente.");
        }

        cpf = cpf.replace(".", "").replace("-", "");
        if (!CpfValidador.isValid(cpf)) {
            throw new PessoaNotFoundException("CPF inválido. Certifique-se de que o CPF é válido e no formato correto.");
        }

        Long cpfLong;
        try {
            cpfLong = Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new PessoaNotFoundException("Erro ao converter CPF para número. Verifique o formato.");
        }

        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(cpfLong)
                .orElseThrow(() -> new PessoaNotFoundException("Nenhuma pessoa encontrada para o CPF fornecido."));

        return PessoaFisicaDto.fromEntity(pessoaFisica);
    }

    @Override
    public PessoaFisicaDto depositar(PessoaFisicaDto entity) throws EntityNotFoundException, ValidationException {
        return null;
    }

    @Override
    public PessoaFisicaDto enviar(PessoaFisicaDto valor) throws EntityNotFoundException {
        return null;
    }
}

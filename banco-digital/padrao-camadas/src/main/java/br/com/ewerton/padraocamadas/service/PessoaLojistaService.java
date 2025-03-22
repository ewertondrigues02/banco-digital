package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.repository.PessoaLojistaRepository;

import java.util.Optional;

public class PessoaLojistaService {


    private PessoaLojistaRepository lojistaRepository;

    private PessoaLojista lojista;

    public Optional<PessoaLojista> findCnpj(String cnpj) throws PessoaNotFoundException {
        if (lojistaRepository.findByPessoaLojistaCnpj(cnpj).equals(lojista.getPessoaLojistaCnpj())) {
            return lojistaRepository.findByPessoaLojistaCnpj(cnpj);
        } else {
            throw new PessoaNotFoundException("Cnpj não encontrado");
        }
    }
}

package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.repository.PessoaLojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaLojistaService {

    private final PessoaLojistaRepository lojistaRepository;

    @Autowired
    public PessoaLojistaService(PessoaLojistaRepository lojistaRepository) {
        this.lojistaRepository = lojistaRepository;
    }

    public Optional<PessoaLojista> findCnpj(String cnpj) {
        return lojistaRepository.findByPessoaLojistaCnpj(cnpj)
                .or(() -> {
                    throw new PessoaNotFoundException("CNPJ não encontrado");
                });
    }
}

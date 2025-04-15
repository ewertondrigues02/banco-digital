package br.com.ewerton.padraocamadas.repository;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.TransacaoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    Optional<PessoaFisica> findByPessoaFisicaCpf(String pessoaFisicaCpf);
    TransacaoDto getSaldo(BigDecimal valor);
}

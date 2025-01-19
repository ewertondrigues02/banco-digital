package br.com.ewerton.padraocamadas.repository;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

}

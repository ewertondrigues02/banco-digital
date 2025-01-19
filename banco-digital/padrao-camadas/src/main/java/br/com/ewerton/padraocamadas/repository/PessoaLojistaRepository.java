package br.com.ewerton.padraocamadas.repository;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaLojistaRepository extends JpaRepository<PessoaLojista, Long> {

}

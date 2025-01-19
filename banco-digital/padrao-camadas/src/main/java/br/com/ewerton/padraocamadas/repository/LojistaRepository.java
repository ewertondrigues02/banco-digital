package br.com.ewerton.padraocamadas.repository;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojistaRepository extends JpaRepository<PessoaLojista, Long> {

}

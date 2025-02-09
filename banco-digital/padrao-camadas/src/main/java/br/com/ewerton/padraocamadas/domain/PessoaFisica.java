package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "ID")
    private Long pessoaFisicaID;

    @NotNull(message = "CPF não pode ser nulo")
    @Column(unique = true, nullable = false, name = "CPF")
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    private String pessoaFisicaCpf;

    public PessoaFisica(Long pessoaFisicaID, String pessoaNome, String pessoaEmail, BigDecimal pessoaSaldo, Integer pessoaSenha, String pessoaFisicaCpf) {
        super(pessoaNome, pessoaEmail, pessoaSaldo, pessoaSenha);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
        this.pessoaFisicaID = pessoaFisicaID;
    }

    public PessoaFisica() {
    }

    public Long getPessoaFisicaID() {
        return pessoaFisicaID;
    }

    public void setPessoaFisicaID(Long pessoaFisicaID) {
        this.pessoaFisicaID = pessoaFisicaID;
    }

    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    public void setPessoaFisicaCpf(String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }
}

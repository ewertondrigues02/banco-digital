package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    private static final long servialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "ID")
    private Long pessoaFisicaID;

    @NotNull(message = "CPF não pode ser nulo")
    @Column(unique = true, nullable = false, name = "pessoa_fisica_cpf")
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

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "pessoaFisicaID=" + pessoaFisicaID +
                ", pessoaFisicaCpf='" + pessoaFisicaCpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(getPessoaFisicaID(), that.getPessoaFisicaID()) && Objects.equals(getPessoaFisicaCpf(), that.getPessoaFisicaCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPessoaFisicaID(), getPessoaFisicaCpf());
    }
}

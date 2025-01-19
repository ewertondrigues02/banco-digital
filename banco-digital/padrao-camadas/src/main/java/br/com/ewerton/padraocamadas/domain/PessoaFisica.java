package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "Pessoa_Fisica")
public class PessoaFisica extends Pessoa{

    @NotNull(message = "CPF não pode ser nulo")
    @Column(unique = true, nullable = false, name = "CPF")
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    private String pessoaFisicaCpf;

    public PessoaFisica(Long pessoaId ,String pessoaNome, String pessoaEmail, Double pessoaSaldo ,Integer pessoaSenha, String pessoaFisicaCpf) {
        super(pessoaId, pessoaNome, pessoaEmail, pessoaSaldo, pessoaSenha);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    public PessoaFisica() {
    }

    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    public void setPessoaFisicaCPF(String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "pessoaFisicaCpf='" + pessoaFisicaCpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(getPessoaFisicaCpf(), that.getPessoaFisicaCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPessoaFisicaCpf());
    }
}

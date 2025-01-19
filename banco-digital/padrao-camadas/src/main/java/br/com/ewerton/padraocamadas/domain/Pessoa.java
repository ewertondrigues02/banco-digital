package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@MappedSuperclass
public abstract class Pessoa {

    @NotNull(message = "Nome não pode ser nulo")
    @Column(name = "Nome")
    private String pessoaNome;

    @NotNull(message = "Email não pode ser nulo")
    @Column(unique = true, nullable = false, name = "E_mail")
    @Email(message = "Email deve ser válido")
    private String pessoaEmail;

    @Column(name = "Saldo")
    private Double pessoaSaldo;

    @Column(name = "Senha")
    @NotNull(message = "Senha não pode ser nula")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private Integer pessoaSenha;

    public Pessoa() {
    }

    public Pessoa(String pessoaNome, String pessoaEmail, Double pessoaSaldo, Integer pessoaSenha) {
        this.pessoaNome = pessoaNome;
        this.pessoaEmail = pessoaEmail;
        this.pessoaSaldo = pessoaSaldo;
        this.pessoaSenha = pessoaSenha;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaEmail() {
        return pessoaEmail;
    }

    public void setPessoaEmail(String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    public Double getPessoaSaldo() {
        return pessoaSaldo;
    }

    public void setPessoaSaldo(Double pessoaSaldo) {
        this.pessoaSaldo = pessoaSaldo;
    }


    public Integer getPessoaSenha() {
        return pessoaSenha;
    }

    public void setPessoaSenha(Integer pessoaSenha) {
        this.pessoaSenha = pessoaSenha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoaNome='" + pessoaNome + '\'' +
                ", pessoaEmail='" + pessoaEmail + '\'' +
                ", pessoaSaldo=" + pessoaSaldo +
                ", pessoaSenha=" + pessoaSenha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getPessoaNome(), pessoa.getPessoaNome()) && Objects.equals(getPessoaEmail(), pessoa.getPessoaEmail()) && Objects.equals(getPessoaSaldo(), pessoa.getPessoaSaldo()) && Objects.equals(getPessoaSenha(), pessoa.getPessoaSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPessoaNome(), getPessoaEmail(), getPessoaSaldo(), getPessoaSenha());
    }
}

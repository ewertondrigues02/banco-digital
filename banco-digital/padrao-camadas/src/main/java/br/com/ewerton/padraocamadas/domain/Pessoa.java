package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaId;

    @NotNull(message = "Nome não pode ser nulo")
    @Column(name = "Nome")
    private String pessoaNome;

    @NotNull(message = "Email não pode ser nulo")
    @Column(unique = true, nullable = false, name = "E-mail")
    @Email(message = "Email deve ser válido")
    private String pessoaEmail;

    @Column(name = "Saldo")
    private Double pessoaSaldo;

    @NotNull(message = "Senha não pode ser nula")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private Integer pessoaSenha;

    public Pessoa() {}

    public Pessoa(Long pessoaId, String pessoaNome, String pessoaEmail, Double pessoaSaldo, Integer pessoaSenha) {
        this.pessoaId = pessoaId;
        this.pessoaNome = pessoaNome;
        this.pessoaEmail = pessoaEmail;
        this.pessoaSaldo = pessoaSaldo;
        this.pessoaSenha = pessoaSenha;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public @NotNull(message = "Nome não pode ser nulo") String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(@NotNull(message = "Nome não pode ser nulo") String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public @NotNull(message = "Email não pode ser nulo") @Email(message = "Email deve ser válido") String getPessoaEmail() {
        return pessoaEmail;
    }

    public void setPessoaEmail(@NotNull(message = "Email não pode ser nulo") @Email(message = "Email deve ser válido") String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    public Double getPessoaSaldo() {
        return pessoaSaldo;
    }

    public void setPessoaSaldo(Double pessoaSaldo) {
        this.pessoaSaldo = pessoaSaldo;
    }

    public @NotNull(message = "Senha não pode ser nula") @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres") Integer getPessoaSenha() {
        return pessoaSenha;
    }

    public void setPessoaSenha(@NotNull(message = "Senha não pode ser nula") @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres") Integer pessoaSenha) {
        this.pessoaSenha = pessoaSenha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoaId=" + pessoaId +
                ", pessoaNome='" + pessoaNome + '\'' +
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
        return Objects.equals(getPessoaId(), pessoa.getPessoaId()) && Objects.equals(getPessoaNome(), pessoa.getPessoaNome()) && Objects.equals(getPessoaEmail(), pessoa.getPessoaEmail()) && Objects.equals(getPessoaSaldo(), pessoa.getPessoaSaldo()) && Objects.equals(getPessoaSenha(), pessoa.getPessoaSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPessoaId(), getPessoaNome(), getPessoaEmail(), getPessoaSaldo(), getPessoaSenha());
    }
}

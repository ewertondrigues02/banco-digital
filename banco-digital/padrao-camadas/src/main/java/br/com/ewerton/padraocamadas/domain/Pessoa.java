package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

}

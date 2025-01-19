package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "tb_pessoa_lojista")
public class PessoaLojista extends Pessoa{

    @NotNull(message = "CNPJ não pode ser nulo")
    @Column(unique = true, nullable = false, name = "CNPJ")
    @Pattern(regexp = "^[0-9]{2}\\.([0-9]{3}){2}\\/([0-9]{4}){2}\\-[0-9]{2}$", message = "CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX")
    private String pessoaLojistaCnpj;

    public PessoaLojista(Long pessoaId ,String pessoaNome, String pessoaEmail, Double pessoaSaldo ,Integer pessoaSenha, String pessoaLojistaCnpj) {
        super(pessoaId, pessoaNome, pessoaEmail, pessoaSaldo, pessoaSenha);
        this.pessoaLojistaCnpj = pessoaLojistaCnpj;
    }

    public PessoaLojista() {
    }

    public String getPessoaLojistaCnpj() {
        return pessoaLojistaCnpj;
    }

    public void setPessoaLojistaCnpj(String pessoaLojistaCnpj) {
        this.pessoaLojistaCnpj = pessoaLojistaCnpj;
    }

    @Override
    public String toString() {
        return "PessoaLojista{" +
                "pessoaLojistaCnpj='" + pessoaLojistaCnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaLojista that = (PessoaLojista) o;
        return Objects.equals(getPessoaLojistaCnpj(), that.getPessoaLojistaCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPessoaLojistaCnpj());
    }
}
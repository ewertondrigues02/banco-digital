package br.com.ewerton.padraocamadas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa_lojista")
public class PessoaLojista extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "ID")
    private Long pessoaLojistaID;

    @NotNull(message = "CNPJ não pode ser nulo")
    @Column(unique = true, nullable = false, name = "pessoa_lojista_cnpj")
    @Pattern(regexp = "^[0-9]{2}\\.([0-9]{3}){2}\\/([0-9]{4}){2}\\-[0-9]{2}$", message = "CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX")
    private String pessoaLojistaCnpj;

    public PessoaLojista(Long pessoaLojistaID , String pessoaNome, String pessoaEmail, BigDecimal pessoaSaldo , Integer pessoaSenha, String pessoaLojistaCnpj) {
        super( pessoaNome, pessoaEmail, pessoaSaldo, pessoaSenha);
        this.pessoaLojistaCnpj = pessoaLojistaCnpj;
        this.pessoaLojistaID = pessoaLojistaID;
    }

    public PessoaLojista(){}

    public String getPessoaLojistaCnpj() {
        return pessoaLojistaCnpj;
    }

    public void setPessoaLojistaCnpj(String pessoaLojistaCnpj) {
        this.pessoaLojistaCnpj = pessoaLojistaCnpj;
    }

    public Long getPessoaLojistaID() {
        return pessoaLojistaID;
    }

    public void setPessoaLojistaID(Long pessoaLojistaID) {
        this.pessoaLojistaID = pessoaLojistaID;
    }

    @Override
    public String toString() {
        return "PessoaLojista{" +
                "pessoaLojistaID=" + pessoaLojistaID +
                ", pessoaLojistaCnpj='" + pessoaLojistaCnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaLojista that = (PessoaLojista) o;
        return Objects.equals(getPessoaLojistaID(), that.getPessoaLojistaID()) && Objects.equals(getPessoaLojistaCnpj(), that.getPessoaLojistaCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPessoaLojistaID(), getPessoaLojistaCnpj());
    }
}

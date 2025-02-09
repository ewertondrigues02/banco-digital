package br.com.ewerton.padraocamadas.dto;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;

import java.math.BigDecimal;

public class PessoaFisicaDto {

    private Long pessoaFisicaIdDto;
    private String pessoaFisicaNomeDto;
    private String pessoaFisicaEmailDto;
    private BigDecimal pessoaFisicaSaldoDto;
    private Integer pessoaFisicaSenhaDto;
    private String pessoaFisicaCpfDto;

    public PessoaFisicaDto() {
    }

    public PessoaFisicaDto(Long pessoaFisicaIdDto, String pessoaFisicaNomeDto, String pessoaFisicaEmailDto, BigDecimal pessoaFisicaSaldoDto, Integer pessoaFisicaSenhaDto, String pessoaFisicaCpfDto) {
        this.pessoaFisicaIdDto = pessoaFisicaIdDto;
        this.pessoaFisicaNomeDto = pessoaFisicaNomeDto;
        this.pessoaFisicaEmailDto = pessoaFisicaEmailDto;
        this.pessoaFisicaSaldoDto = pessoaFisicaSaldoDto;
        this.pessoaFisicaSenhaDto = pessoaFisicaSenhaDto;
        this.pessoaFisicaCpfDto = pessoaFisicaCpfDto;
    }


    public Long getPessoaFisicaIdDto() {
        return pessoaFisicaIdDto;
    }

    public void setPessoaFisicaIdDto(Long pessoaFisicaIdDto) {
        this.pessoaFisicaIdDto = pessoaFisicaIdDto;
    }

    public String getPessoaFisicaNomeDto() {
        return pessoaFisicaNomeDto;
    }

    public void setPessoaFisicaNomeDto(String pessoaFisicaNomeDto) {
        this.pessoaFisicaNomeDto = pessoaFisicaNomeDto;
    }

    public String getPessoaFisicaEmailDto() {
        return pessoaFisicaEmailDto;
    }

    public void setPessoaFisicaEmailDto(String pessoaFisicaEmailDto) {
        this.pessoaFisicaEmailDto = pessoaFisicaEmailDto;
    }

    public BigDecimal getPessoaFisicaSaldoDto() {
        return pessoaFisicaSaldoDto;
    }

    public void setPessoaFisicaSaldoDto(BigDecimal pessoaFisicaSaldoDto) {
        this.pessoaFisicaSaldoDto = pessoaFisicaSaldoDto;
    }

    public Integer getPessoaFisicaSenhaDto() {
        return pessoaFisicaSenhaDto;
    }

    public void setPessoaFisicaSenhaDto(Integer pessoaFisicaSenhaDto) {
        this.pessoaFisicaSenhaDto = pessoaFisicaSenhaDto;
    }

    public String getPessoaFisicaCpfDto() {
        return pessoaFisicaCpfDto;
    }

    public void setPessoaFisicaCpfDto(String pessoaFisicaCpfDto) {
        this.pessoaFisicaCpfDto = pessoaFisicaCpfDto;
    }

    public PessoaFisica toEntity() {
        return new PessoaFisica(
                this.pessoaFisicaIdDto,
                this.pessoaFisicaNomeDto,
                this.pessoaFisicaEmailDto,
                this.pessoaFisicaSaldoDto,
                this.pessoaFisicaSenhaDto,
                this.pessoaFisicaCpfDto
        );
    }

    public static PessoaFisicaDto fromEntity(PessoaFisica pessoaFisica) {
        return new PessoaFisicaDto(
                pessoaFisica.getPessoaFisicaID(),
                pessoaFisica.getPessoaNome(),
                pessoaFisica.getPessoaEmail(),
                pessoaFisica.getPessoaSaldo(),
                pessoaFisica.getPessoaSenha(),
                pessoaFisica.getPessoaFisicaCpf()
        );
    }
}

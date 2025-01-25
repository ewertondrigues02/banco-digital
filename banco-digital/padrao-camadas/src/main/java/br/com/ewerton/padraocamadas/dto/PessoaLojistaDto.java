package br.com.ewerton.padraocamadas.dto;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;

public class PessoaLojistaDto {

    private Long pessoaLojistaIdDto;
    private String pessoaLojistaNomeDto;
    private String pessoaLojistaEmailDto;
    private Double pessoaLojistaSaldoDto;
    private Integer pessoaLojistaSenhaDto;
    private String pessoaLojistaCnpjDto;

    public PessoaLojistaDto(Long pessoaLojistaIdDto, String pessoaLojistaNomeDto, String pessoaLojistaEmailDto, Double pessoaLojistaSaldoDto, Integer pessoaLojistaSenhaDto, String pessoaLojistaCnpjDto) {
        this.pessoaLojistaIdDto = pessoaLojistaIdDto;
        this.pessoaLojistaNomeDto = pessoaLojistaNomeDto;
        this.pessoaLojistaEmailDto = pessoaLojistaEmailDto;
        this.pessoaLojistaSaldoDto = pessoaLojistaSaldoDto;
        this.pessoaLojistaSenhaDto = pessoaLojistaSenhaDto;
        this.pessoaLojistaCnpjDto = pessoaLojistaCnpjDto;
    }

    public Long getPessoaLojistaIdDto() {
        return pessoaLojistaIdDto;
    }

    public void setPessoaLojistaIdDto(Long pessoaLojistaIdDto) {
        this.pessoaLojistaIdDto = pessoaLojistaIdDto;
    }

    public String getPessoaLojistaNomeDto() {
        return pessoaLojistaNomeDto;
    }

    public void setPessoaLojistaNomeDto(String pessoaLojistaNomeDto) {
        this.pessoaLojistaNomeDto = pessoaLojistaNomeDto;
    }

    public String getPessoaLojistaEmailDto() {
        return pessoaLojistaEmailDto;
    }

    public void setPessoaLojistaEmailDto(String pessoaLojistaEmailDto) {
        this.pessoaLojistaEmailDto = pessoaLojistaEmailDto;
    }

    public Double getPessoaLojistaSaldoDto() {
        return pessoaLojistaSaldoDto;
    }

    public void setPessoaLojistaSaldoDto(Double pessoaLojistaSaldoDto) {
        this.pessoaLojistaSaldoDto = pessoaLojistaSaldoDto;
    }

    public Integer getPessoaLojistaSenhaDto() {
        return pessoaLojistaSenhaDto;
    }

    public void setPessoaLojistaSenhaDto(Integer pessoaLojistaSenhaDto) {
        this.pessoaLojistaSenhaDto = pessoaLojistaSenhaDto;
    }

    public String getPessoaLojistaCnpjDto() {
        return pessoaLojistaCnpjDto;
    }

    public void setPessoaLojistaCnpjDto(String pessoaLojistaCnpjDto) {
        this.pessoaLojistaCnpjDto = pessoaLojistaCnpjDto;
    }

    public PessoaLojista toEntity() {
        return new PessoaLojista(
                this.pessoaLojistaIdDto,
                this.pessoaLojistaNomeDto,
                this.pessoaLojistaEmailDto,
                this.pessoaLojistaSaldoDto,
                this.pessoaLojistaSenhaDto,
                this.pessoaLojistaCnpjDto
        );
    }

    public static PessoaLojistaDto fromEntity(PessoaLojista pessoaLojista) {
        return new PessoaLojistaDto(
                pessoaLojista.getPessoaLojistaID(),
                pessoaLojista.getPessoaNome(),
                pessoaLojista.getPessoaEmail(),
                pessoaLojista.getPessoaSaldo(),
                pessoaLojista.getPessoaSenha(),
                pessoaLojista.getPessoaLojistaCnpj()
        );
    }
}

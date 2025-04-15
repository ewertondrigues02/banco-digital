package br.com.ewerton.padraocamadas.dto;

import java.math.BigDecimal;

public class TransacaoDto {

    private PessoaFisicaDto remetente;
    private PessoaFisicaDto destinatario;
    private BigDecimal valor;

    public TransacaoDto(PessoaFisicaDto remetente, PessoaFisicaDto destinatario, BigDecimal valor) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    public TransacaoDto(){}

    public PessoaFisicaDto getRemetente() {
        return remetente;
    }

    public void setRemetente(PessoaFisicaDto remetente) {
        this.remetente = remetente;
    }

    public PessoaFisicaDto getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(PessoaFisicaDto destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "TransacaoDto{" +
                "remetente=" + remetente +
                ", destinatario=" + destinatario +
                ", valor=" + valor +
                '}';
    }
}

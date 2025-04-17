package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaFisicaServiceTest {

    @Mock
    private PessoaFisicaRepository pessoaFisicaRepository;

    @InjectMocks
    private PessoaFisicaService pessoaFisicaService;

    private PessoaFisica pessoa;
    private PessoaFisicaDto pessoaDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pessoa = new PessoaFisica();
        pessoa.setPessoaFisicaCpf("12345678909");
        pessoa.setPessoaEmail("teste@email.com");
        pessoa.setPessoaSaldo(new BigDecimal("100"));

        pessoaDto = PessoaFisicaDto.fromEntity(pessoa);
    }

    @Test
    void deveConsultarPessoaFisicaPorCpf() {
        // Arrange
        when(pessoaFisicaRepository.findByPessoaFisicaCpf("12345678909"))
                .thenReturn(Optional.of(pessoa));

        PessoaFisicaDto result = pessoaFisicaService.consultar("12345678909");

        assertNotNull(result);
        assertEquals("12345678909", result.getPessoaFisicaCpfDto());
    }

    @Test
    void deveLancarExcecaoSeCpfInvalidoNaConsulta() {
        // Act & Assert
        assertThrows(PessoaNotFoundException.class, () -> {
            pessoaFisicaService.consultar("11111111111"); // CPF inválido
        });
    }

    @Test
    void deveLancarExcecaoSePessoaNaoEncontrada() {
        when(pessoaFisicaRepository.findByPessoaFisicaCpf("12345678909"))
                .thenReturn(Optional.empty());

        assertThrows(PessoaNotFoundException.class, () -> {
            pessoaFisicaService.consultar("12345678909");
        });
    }

    @Test
    void deveDepositarValorNaContaPessoaFisica() {
        // Arrange
        when(pessoaFisicaRepository.findByPessoaFisicaCpf("12345678909"))
                .thenReturn(Optional.of(pessoa));

        BigDecimal valorDeposito = new BigDecimal("50.00");

        PessoaFisicaDto result = pessoaFisicaService.depositar(pessoaDto, valorDeposito);

        assertEquals(new BigDecimal("150.00"), result.getPessoaFisicaSaldoDto());
        verify(pessoaFisicaRepository).save(any(PessoaFisica.class));
    }

    @Test
    void deveLancarExcecaoSeValorDepositoForZero() {
        BigDecimal valor = BigDecimal.ZERO;

        assertThrows(ValidationException.class, () -> {
            pessoaFisicaService.depositar(pessoaDto, valor);
        });
    }

    @Test
    void deveLancarExcecaoSePessoaNaoEncontradaParaDeposito() {
        when(pessoaFisicaRepository.findByPessoaFisicaCpf("12345678909"))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            pessoaFisicaService.depositar(pessoaDto, new BigDecimal("100"));
        });
    }
}

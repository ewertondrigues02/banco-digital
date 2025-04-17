package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.repository.PessoaLojistaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaLojistaServiceTest {

    private PessoaLojistaRepository lojistaRepository;
    private PessoaLojistaService lojistaService;

    @BeforeEach
    void setUp() {
        lojistaRepository = mock(PessoaLojistaRepository.class);
        lojistaService = new PessoaLojistaService(lojistaRepository);
    }

    @Test
    void deveRetornarPessoaLojistaQuandoCnpjExistir() {
        // Arrange
        String cnpj = "12.345.678/0001-90";
        PessoaLojista lojista = new PessoaLojista();
        lojista.setPessoaLojistaCnpj(cnpj);

        when(lojistaRepository.findByPessoaLojistaCnpj(cnpj)).thenReturn(Optional.of(lojista));

        PessoaLojista resultado = lojistaService.findCnpj(cnpj);

        assertNotNull(resultado);
        assertEquals(cnpj, resultado.getPessoaLojistaCnpj());
        verify(lojistaRepository, times(1)).findByPessoaLojistaCnpj(cnpj);
    }

    @Test
    void deveLancarExcecaoQuandoCnpjNaoForEncontrado() {

        String cnpj = "00.000.000/0000-00";
        when(lojistaRepository.findByPessoaLojistaCnpj(cnpj)).thenReturn(Optional.empty());


        PessoaNotFoundException exception = assertThrows(PessoaNotFoundException.class, () -> {
            lojistaService.findCnpj(cnpj);
        });

        assertEquals("CNPJ não encontrado", exception.getMessage());
        verify(lojistaRepository, times(1)).findByPessoaLojistaCnpj(cnpj);
    }
}

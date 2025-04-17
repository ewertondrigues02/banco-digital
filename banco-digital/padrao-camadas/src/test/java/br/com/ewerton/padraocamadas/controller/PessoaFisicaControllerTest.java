package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.TransacaoDto;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.service.PessoaFisicaService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaFisicaControllerTest {

    @Mock
    private PessoaFisicaService pessoaFisicaService;

    @InjectMocks
    private PessoaFisicaController pessoaFisicaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCpf_ReturnsPessoaFisicaDto() {
        String cpf = "12345678901";
        PessoaFisicaDto dto = new PessoaFisicaDto();
        when(pessoaFisicaService.consultar(cpf)).thenReturn(dto);

        ResponseEntity<PessoaFisicaDto> response = pessoaFisicaController.findByCpf(cpf);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testEnviarPessoaFisica_ReturnsUpdatedPessoaFisicaDto() {
        TransacaoDto transacao = new TransacaoDto();
        transacao.setRemetente("12345678901");
        transacao.setDestinatario("09876543210");
        transacao.setValor(100.0);

        PessoaFisicaDto dto = new PessoaFisicaDto();
        when(pessoaFisicaService.enviarParaPessoaFisica("12345678901", "09876543210", 100.0)).thenReturn(dto);

        ResponseEntity<PessoaFisicaDto> response = pessoaFisicaController.enviarPessoaFisica(transacao);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testDepositar_Success() {
        PessoaFisicaDto pessoaDto = new PessoaFisicaDto();
        double valor = 200.0;

        PessoaFisicaController.DepositoRequest request = new PessoaFisicaController.DepositoRequest();
        request.setPessoaFisicaDto(pessoaDto);
        request.setValor(valor);

        when(pessoaFisicaService.depositar(pessoaDto, valor)).thenReturn(pessoaDto);

        ResponseEntity<?> response = pessoaFisicaController.depositar(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(pessoaDto, response.getBody());
    }

    @Test
    void testDepositar_ThrowsValidationException() {
        PessoaFisicaDto pessoaDto = new PessoaFisicaDto();
        double valor = -100.0;

        PessoaFisicaController.DepositoRequest request = new PessoaFisicaController.DepositoRequest();
        request.setPessoaFisicaDto(pessoaDto);
        request.setValor(valor);

        when(pessoaFisicaService.depositar(pessoaDto, valor)).thenThrow(new ValidationException("Valor inválido"));

        ResponseEntity<?> response = pessoaFisicaController.depositar(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Valor inválido", response.getBody());
    }

    @Test
    void testDepositar_ThrowsEntityNotFoundException() {
        PessoaFisicaDto pessoaDto = new PessoaFisicaDto();
        double valor = 50.0;

        PessoaFisicaController.DepositoRequest request = new PessoaFisicaController.DepositoRequest();
        request.setPessoaFisicaDto(pessoaDto);
        request.setValor(valor);

        when(pessoaFisicaService.depositar(pessoaDto, valor)).thenThrow(new EntityNotFoundException("Pessoa não encontrada"));

        ResponseEntity<?> response = pessoaFisicaController.depositar(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Pessoa não encontrada", response.getBody());
    }
}

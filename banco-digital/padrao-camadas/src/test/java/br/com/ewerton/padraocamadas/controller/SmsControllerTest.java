package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.service.SmsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SmsControllerTest {

    @Mock
    private SmsService smsService;

    @InjectMocks
    private SmsController smsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEnviarSms_Success() {
        String numeroDestino = "+5511999999999";
        String mensagem = "Olá! Esta é uma mensagem de teste.";
        String respostaEsperada = "SMS enviado com sucesso";

        when(smsService.enviarSms(numeroDestino, mensagem)).thenReturn(respostaEsperada);

        ResponseEntity<String> response = smsController.enviarSms(numeroDestino, mensagem);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(respostaEsperada, response.getBody());
    }

    @Test
    void testEnviarSms_Falha() {
        String numeroDestino = "+5511999999999";
        String mensagem = "Mensagem com erro";
        String erroEsperado = "Erro ao enviar SMS";

        when(smsService.enviarSms(numeroDestino, mensagem)).thenReturn(erroEsperado);

        ResponseEntity<String> response = smsController.enviarSms(numeroDestino, mensagem);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(erroEsperado, response.getBody());
    }
}

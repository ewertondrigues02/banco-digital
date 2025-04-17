package br.com.ewerton.padraocamadas.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @Captor
    private ArgumentCaptor<SimpleMailMessage> messageCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEnviarEmailSimples_DeveChamarMailSenderComParametrosCorretos() {

        String para = "destinatario@email.com";
        String assunto = "Assunto de Teste";
        String corpo = "Corpo do e-mail";


        emailService.enviarEmailSimples(para, assunto, corpo);


        verify(mailSender, times(1)).send(messageCaptor.capture());

        SimpleMailMessage mensagemEnviada = messageCaptor.getValue();
        assertEquals(para, mensagemEnviada.getTo()[0]);
        assertEquals(assunto, mensagemEnviada.getSubject());
        assertEquals(corpo, mensagemEnviada.getText());
        assertEquals("no-reply@seudominio.com", mensagemEnviada.getFrom());
    }
}

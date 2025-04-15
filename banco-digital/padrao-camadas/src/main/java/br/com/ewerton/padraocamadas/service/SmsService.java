package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.config.TwilioConfig;
import com.twilio.sdk.Twilio;
import jakarta.mail.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private final TwilioConfig config;

    @Autowired
    public SmsService(TwilioConfig config) {
        this.config = config;
        Twilio.init(config.getAccountSid(), config.getAuthToken());
    }

    public String enviarSms(String para, String mensagemTexto) {
        Message mensagem = Message.creator(
                new com.twilio.type.PhoneNumber(para),
                new com.twilio.type.PhoneNumber(config.getFromNumber()),
                mensagemTexto
        ).create();

        return "Mensagem enviada com SID: " + mensagem.getSid();
    }
}

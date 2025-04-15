package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.service.SmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
@Tag(name = "SMS", description = "Envio de mensagens SMS usando a API do Twilio")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/enviar")
    @Operation(summary = "Enviar SMS", description = "Envia uma mensagem SMS para o número informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SMS enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao enviar SMS ou parâmetros inválidos")
    })
    public ResponseEntity<String> enviarSms(
            @Parameter(description = "Número de telefone de destino (ex: +5511999999999)")
            @RequestParam String para,

            @Parameter(description = "Mensagem a ser enviada via SMS")
            @RequestParam String mensagem) {

        String resultado = smsService.enviarSms(para, mensagem);
        return ResponseEntity.ok(resultado);
    }
}

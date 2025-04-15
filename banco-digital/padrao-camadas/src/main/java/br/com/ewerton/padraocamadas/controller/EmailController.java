package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@Tag(name = "E-mail", description = "Envio de e-mails simples")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    @Operation(summary = "Enviar e-mail", description = "Envia um e-mail simples para o destinatário informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "E-mail enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao enviar

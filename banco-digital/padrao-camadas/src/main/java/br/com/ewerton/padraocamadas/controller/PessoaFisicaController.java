package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.TransacaoDto;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.service.PessoaFisicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas_fisicas")
@Tag(name = "Pessoa Física", description = "Endpoints para operações com Pessoa Física")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/{cpf}")
    @Operation(summary = "Consultar por CPF", description = "Consulta uma pessoa física pelo CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa física encontrada"),
            @ApiResponse(responseCode = "404", description = "Pessoa física não encontrada")
    })
    public ResponseEntity<PessoaFisicaDto> findByCpf(@PathVariable String cpf) {
        PessoaFisicaDto objPessoaFisica = pessoaFisicaService.consultar(cpf);
        return ResponseEntity.ok().body(objPessoaFisica);
    }

    @PostMapping("/enviar")
    @Operation(summary = "Transferência entre pessoas físicas", description = "Envia valor de uma pessoa para outra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transferência realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou dados incorretos"),
            @ApiResponse(responseCode = "404", description = "Remetente ou destinatário não encontrado")
    })
    public ResponseEntity<PessoaFisicaDto> enviarPessoaFisica(@RequestBody TransacaoDto transacao) {
        PessoaFisicaDto objTransacao = pessoaFisicaService.enviarParaPessoaFisica(
                transacao.getRemetente(),
                transacao.getDestinatario(),
                transacao.getValor()
        );
        return ResponseEntity.ok().body(objTransacao);
    }

    @PostMapping("/depositar")
    @Operation(summary = "Realizar depósito", description = "Efetua um depósito no saldo da pessoa física")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Depósito realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou CPF inválido"),
            @ApiResponse(responseCode = "404", description = "Pessoa física não encontrada")
    })
    public ResponseEntity<?> depositar(@RequestBody DepositoRequest request) {
        try {
            PessoaFisicaDto resultado = pessoaFisicaService.depositar(request.getPessoaFisicaDto(), request.getValor());
            return ResponseEntity.ok(resultado);
        } catch (EntityNotFoundException | ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

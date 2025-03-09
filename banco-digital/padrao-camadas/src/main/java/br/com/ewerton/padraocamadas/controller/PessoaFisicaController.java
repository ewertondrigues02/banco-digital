package br.com.ewerton.padraocamadas.controller;

import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pessoas_fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaFisicaDto> findByCpf(@PathVariable String cpf) {
        PessoaFisicaDto objPessoaFisica = pessoaFisicaService.consultar(cpf);
        return ResponseEntity.ok().body(objPessoaFisica);
    }

    public ResponseEntity<PessoaFisicaDto> enviarPessoaFisica(@PathVariable String cpfRemetente, @PathVariable String cpfDestinatario, @PathVariable BigDecimal valor) {
        pessoaFisicaService.
    }

}

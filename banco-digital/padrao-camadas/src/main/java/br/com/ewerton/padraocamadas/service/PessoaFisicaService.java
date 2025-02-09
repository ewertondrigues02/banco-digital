package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import br.com.ewerton.padraocamadas.utils.CpfValidador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisicaDto, String> {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    private PessoaFisica pessoaFisica;

    private PessoaFisicaDto pessoaFisicaDto;


    @Override
    public PessoaFisicaDto consultar(String cpf) throws PessoaNotFoundException {
        if (cpf == null || cpf.isEmpty()) {
            throw new PessoaNotFoundException("CPF nulo ou vazio, favor tente novamente.");
        }

        cpf = cpf.replace(".", "").replace("-", "");
        if (!CpfValidador.isValid(cpf)) {
            throw new PessoaNotFoundException("CPF inválido. Certifique-se de que o CPF é válido e no formato correto.");
        }

        Long cpfLong;
        try {
            cpfLong = Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new PessoaNotFoundException("Erro ao converter CPF para número. Verifique o formato.");
        }

        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(cpfLong)
                .orElseThrow(() -> new PessoaNotFoundException("Nenhuma pessoa encontrada para o CPF fornecido."));

        return PessoaFisicaDto.fromEntity(pessoaFisica);
    }

    @Override
    public PessoaFisicaDto depositar(PessoaFisicaDto entity, BigDecimal valor) throws EntityNotFoundException, ValidationException {
        if (!Objects.equals(entity.getPessoaFisicaCpfDto(), pessoaFisica.getPessoaFisicaCpf()) ||
                !Objects.equals(entity.getPessoaFisicaEmailDto(), pessoaFisica.getPessoaEmail()) || CpfValidador.isValid(entity.getPessoaFisicaCpfDto())) {
            throw new EntityNotFoundException("Não foi possível fazer o depósito. Verifique os dados novamente.");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Valor inválido, o valor precisa ser maior que 0: " + valor);
        }
        pessoaFisica.setPessoaSaldo(pessoaFisica.getPessoaSaldo().add(valor));
        pessoaFisicaRepository.save(pessoaFisica);
        return entity.fromEntity(pessoaFisica);
    }

    @Override
    public PessoaFisicaDto enviar(PessoaFisicaDto entityRemetente, PessoaFisicaDto entityDestino, BigDecimal valor, Instant horaTransferencia) throws EntityNotFoundException, ValidationException {

        if (entityRemetente == null || entityDestino == null) {
            throw new EntityNotFoundException("Remetente ou destinatário inválidos.");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("O valor da transferência deve ser maior que zero.");
        }
        if (!CpfValidador.isValid(entityRemetente.getPessoaFisicaCpfDto()) ||
                !CpfValidador.isValid(entityDestino.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do remetente ou destinatário inválido.");
        }
        if (entityRemetente.getPessoaFisicaSaldoDto().compareTo(valor) < 0) {
            throw new ValidationException("Saldo insuficiente para a transferência.");
        }

        PessoaFisica pessoaFisicaRemetente = pessoaFisicaRepository.findByCpf(entityRemetente.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Remetente não encontrado."));
        PessoaFisica pessoaFisicaDestino = pessoaFisicaRepository.findByCpf(entityDestino.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Destinatário não encontrado."));

        pessoaFisicaRemetente.setPessoaSaldo(pessoaFisicaRemetente.getPessoaSaldo().subtract(valor));
        pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));

        pessoaFisicaRepository.save(pessoaFisicaRemetente);
        pessoaFisicaRepository.save(pessoaFisicaDestino);

        return PessoaFisicaDto.fromEntity(pessoaFisicaRemetente);
    }

}

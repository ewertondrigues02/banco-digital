package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.PessoaLojistaDto;
import br.com.ewerton.padraocamadas.exception.PessoaNotFoundException;
import br.com.ewerton.padraocamadas.exception.ValidationException;
import br.com.ewerton.padraocamadas.repository.PessoaFisicaRepository;
import br.com.ewerton.padraocamadas.repository.PessoaLojistaRepository;
import br.com.ewerton.padraocamadas.utils.CnpjValidador;
import br.com.ewerton.padraocamadas.utils.CpfValidador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Service
public class PessoaFisicaService implements GenericService<PessoaFisicaDto, Long> {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaLojistaRepository pessoaLojistaRepository;

    private PessoaFisica pessoaFisicaDestino;

    private PessoaFisica pessoaFisicaRemetente;

    private PessoaLojista pessoaLojista;

    private PessoaFisicaDto pessoaFisicaDto;

    private PessoaLojistaDto pessoaLojistaDto;


    @Override
    public PessoaFisicaDto consultar(String cpf) throws PessoaNotFoundException {
        validarCpf(cpf);

        PessoaFisica pessoaFisica = pessoaFisicaRepository.findByPessoaFisicaCpf(cpf)
                .orElseThrow(() -> new PessoaNotFoundException("Nenhuma pessoa encontrada para o CPF fornecido."));

        return PessoaFisicaDto.fromEntity(pessoaFisica);
    }

    // Método de validação do CPF
    private void validarCpf(String cpf) throws PessoaNotFoundException {
        if (cpf == null || cpf.isEmpty()) {
            throw new PessoaNotFoundException("CPF não pode ser nulo ou vazio.");
        }

        if (!CpfValidador.isValid(cpf)) {
            throw new PessoaNotFoundException("CPF inválido. Certifique-se de que o CPF é válido e no formato correto.");
        }
    }

    @Override
    public PessoaFisicaDto depositar(PessoaFisicaDto entity, BigDecimal valor) throws EntityNotFoundException, ValidationException {
        // Validação dos dados de entrada
        validarDadosPessoa(entity);
        validarValor(valor);

        // Atualizando o saldo do destinatário
        pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));
        pessoaFisicaRepository.save(pessoaFisicaDestino);

        return entity.fromEntity(pessoaFisicaDestino);
    }

    // Método de validação para dados do remetente
    private void validarDadosPessoa(PessoaFisicaDto entity) throws EntityNotFoundException {
        if (!isPessoaFisicaValida(entity)) {
            throw new EntityNotFoundException("Não foi possível fazer o depósito. Verifique os dados novamente.");
        }
    }

    // Validações separadas para CPF e Email
    private boolean isPessoaFisicaValida(PessoaFisicaDto entity) {
        return Objects.equals(entity.getPessoaFisicaCpfDto(), pessoaFisicaDestino.getPessoaFisicaCpf()) &&
                Objects.equals(entity.getPessoaFisicaEmailDto(), pessoaFisicaDestino.getPessoaEmail()) &&
                CpfValidador.isValid(entity.getPessoaFisicaCpfDto());
    }

    // Método de validação para valor de depósito
    private void validarValor(BigDecimal valor) throws ValidationException {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Valor inválido, o valor precisa ser maior que 0: " + valor);
        }
    }

    @Override
    public PessoaFisicaDto enviar(PessoaFisicaDto entityRemetenteFisica, PessoaFisicaDto entityDestinoFisica, PessoaLojistaDto entityDestinoLojista, BigDecimal valor, Instant horaTransferencia) throws EntityNotFoundException, ValidationException {

        validarEntradas(entityRemetenteFisica, entityDestinoFisica, entityDestinoLojista, valor);

        if (entityDestinoFisica != null) {
            return transferirParaPessoaFisica(entityRemetenteFisica, entityDestinoFisica, valor);
        }

        if (entityDestinoLojista != null) {
            return transferirParaLojista(entityRemetenteFisica, entityDestinoLojista, valor);
        }

        throw new ValidationException("Tipo de destinatário inválido.");
    }

    private void validarEntradas(PessoaFisicaDto remetenteFisica, PessoaFisicaDto destinoFisica, PessoaLojistaDto destinoLojista, BigDecimal valor) throws ValidationException {
        validarRemetenteEDestinatario(remetenteFisica, destinoFisica, destinoLojista);
        validarValor(valor);
        validarCpfRemetente(remetenteFisica);
        validarCpfOuCnpjDestinatario(destinoFisica, destinoLojista);
        validarSaldo(remetenteFisica, valor);
    }

    private void validarRemetenteEDestinatario(PessoaFisicaDto remetenteFisica, PessoaFisicaDto destinoFisica, PessoaLojistaDto destinoLojista) throws EntityNotFoundException {
        if (remetenteFisica == null || (destinoFisica == null && destinoLojista == null)) {
            throw new EntityNotFoundException("Remetente ou destinatário inválidos.");
        }
    }

    private void validarSaldo(PessoaFisicaDto remetenteFisica, BigDecimal valor) throws ValidationException {
        if (remetenteFisica.getPessoaFisicaSaldoDto().compareTo(valor) < 0) {
            throw new ValidationException("Saldo insuficiente para a transferência.");
        }
    }

    // Validar CPF do remetente
    private void validarCpfRemetente(PessoaFisicaDto remetenteFisica) throws ValidationException {
        if (!CpfValidador.isValid(remetenteFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do remetente inválido.");
        }
    }

    // Validar CPF ou CNPJ do destinatário
    private void validarCpfOuCnpjDestinatario(PessoaFisicaDto destinoFisica, PessoaLojistaDto destinoLojista) throws ValidationException {
        if (destinoFisica != null && !CpfValidador.isValid(destinoFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do destinatário inválido.");
        }

        if (destinoLojista != null && !CnpjValidador.isValid(destinoLojista.getPessoaLojistaCnpjDto())) {
            throw new ValidationException("CNPJ do destinatário (Lojista) inválido.");
        }
    }

    private PessoaFisicaDto transferirParaPessoaFisica(PessoaFisicaDto remetenteFisica, PessoaFisicaDto destinoFisica, BigDecimal valor) throws EntityNotFoundException {
        PessoaFisica pessoaFisicaRemetente = pessoaFisicaRepository.findByPessoaFisicaCpf(remetenteFisica.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Remetente não encontrado."));
        PessoaFisica pessoaFisicaDestino = pessoaFisicaRepository.findByPessoaFisicaCpf(destinoFisica.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Destinatário não encontrado."));

        pessoaFisicaRemetente.setPessoaSaldo(pessoaFisicaRemetente.getPessoaSaldo().subtract(valor));
        pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));

        pessoaFisicaRepository.save(pessoaFisicaRemetente);
        pessoaFisicaRepository.save(pessoaFisicaDestino);

        return PessoaFisicaDto.fromEntity(pessoaFisicaRemetente);
    }

    private PessoaFisicaDto transferirParaLojista(PessoaFisicaDto remetenteFisica, PessoaLojistaDto destinoLojista, BigDecimal valor) throws ValidationException, EntityNotFoundException {
        if (remetenteFisica.getPessoaFisicaCpfDto() != null) {
            throw new ValidationException("O Lojista (destinatário) não pode ser o remetente.");
        }

        PessoaLojista pessoaLojistaDestino = pessoaLojistaRepository.findByPessoaLojistaCnpj(destinoLojista.getPessoaLojistaCnpjDto())
                .orElseThrow(() -> new EntityNotFoundException("Destinatário Lojista não encontrado."));

        pessoaLojistaDestino.setPessoaSaldo(pessoaLojistaDestino.getPessoaSaldo().add(valor));

        pessoaLojistaRepository.save(pessoaLojistaDestino);

        return PessoaFisicaDto.fromEntity(remetenteFisica.toEntity());
    }


}

package br.com.ewerton.padraocamadas.service;

import br.com.ewerton.padraocamadas.domain.PessoaFisica;
import br.com.ewerton.padraocamadas.domain.PessoaLojista;
import br.com.ewerton.padraocamadas.dto.PessoaFisicaDto;
import br.com.ewerton.padraocamadas.dto.PessoaLojistaDto;
import br.com.ewerton.padraocamadas.dto.TransacaoDto;
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

        // Buscando a pessoa física correspondente ao DTO (entity)
        PessoaFisica pessoaFisicaDestino = pessoaFisicaRepository.findByPessoaFisicaCpf(entity.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa física não encontrada para o CPF fornecido."));

        // Atualizando o saldo da pessoa física
        pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));

        // Salvando as alterações no banco de dados
        pessoaFisicaRepository.save(pessoaFisicaDestino);

        // Convertendo a entidade atualizada para o DTO e retornando
        return PessoaFisicaDto.fromEntity(pessoaFisicaDestino);
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
    public PessoaFisicaDto enviarParaPessoaFisica(PessoaFisicaDto entityRemetenteFisica, PessoaFisicaDto entityDestinoFisica, BigDecimal valor)
            throws EntityNotFoundException, ValidationException {

        // Buscar a entidade real no banco de dados pelo CPF ou ID
        PessoaFisica remetente = pessoaFisicaRepository.findByPessoaFisicaCpf(entityRemetenteFisica.getPessoaFisicaCpfDto())
                .orElseThrow(() -> new EntityNotFoundException("Remetente não encontrado."));

        //  buscar o saldo e validar
        PessoaFisicaDto saldo = pessoaFisicaRepository.getSaldo(pessoaFisicaDto.getPessoaFisicaSaldoDto());
        validarSaldo(saldo, valor);

        // Depois, segue o fluxo normal
        return transferirParaPessoaFisica(entityRemetenteFisica, entityDestinoFisica, valor);
    }

    @Override
    public PessoaFisicaDto enviarParaLojista(PessoaFisicaDto entityRemetenteFisica, PessoaLojistaDto entityDestinoLojista, BigDecimal valor)
            throws EntityNotFoundException, ValidationException {

        validarEntradasLojista(entityRemetenteFisica, entityDestinoLojista, valor);
        return transferirParaLojista(entityRemetenteFisica, entityDestinoLojista, valor);
    }

    // Validações específicas para transferências entre pessoas físicas
    private void validarEntradasPessoaFisica(PessoaFisicaDto remetenteFisica, PessoaFisicaDto destinoFisica, BigDecimal valor)
            throws ValidationException {

        if (remetenteFisica == null || destinoFisica == null) {
            throw new EntityNotFoundException("Remetente ou destinatário inválidos.");
        }

        validarValor(valor);
        validarCpfRemetente(remetenteFisica);
        validarCpfDestinatario(destinoFisica);
        validarSaldo(remetenteFisica, valor);
    }

    // Validações específicas para transferências para lojistas
    private void validarEntradasLojista(PessoaFisicaDto remetenteFisica, PessoaLojistaDto destinoLojista, BigDecimal valor)
            throws ValidationException {

        if (remetenteFisica == null || destinoLojista == null) {
            throw new EntityNotFoundException("Remetente ou destinatário inválidos.");
        }

        validarValor(valor);
        validarCpfRemetente(remetenteFisica);
        validarCnpjDestinatario(destinoLojista);
        validarSaldo(remetenteFisica, valor);
    }

    // Transferência entre pessoas físicas
    private PessoaFisicaDto transferirParaPessoaFisica(PessoaFisicaDto remetenteFisica, PessoaFisicaDto destinoFisica, BigDecimal valor)
            throws EntityNotFoundException {

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

    // Transferência para lojista
    private PessoaFisicaDto transferirParaLojista(PessoaFisicaDto remetenteFisica, PessoaLojistaDto destinoLojista, BigDecimal valor)
            throws ValidationException, EntityNotFoundException {

        PessoaLojista pessoaLojistaDestino = pessoaLojistaRepository.findByPessoaLojistaCnpj(destinoLojista.getPessoaLojistaCnpjDto())
                .orElseThrow(() -> new EntityNotFoundException("Destinatário Lojista não encontrado."));

        pessoaLojistaDestino.setPessoaSaldo(pessoaLojistaDestino.getPessoaSaldo().add(valor));

        pessoaLojistaRepository.save(pessoaLojistaDestino);

        return PessoaFisicaDto.fromEntity(remetenteFisica.toEntity());
    }

    // Validações auxiliares
    private void validarSaldo(PessoaFisicaDto remetenteFisica, BigDecimal valor) throws ValidationException {
        if (remetenteFisica.getPessoaFisicaSaldoDto() == null ||
                remetenteFisica.getPessoaFisicaSaldoDto().compareTo(valor) < 0) {
            throw new ValidationException("Saldo não informado para a pessoa física.");
        }

        BigDecimal saldo = remetenteFisica.getPessoaFisicaSaldoDto();
        if (saldo.compareTo(valor) < 0) {
            throw new ValidationException("Saldo insuficiente para a transferência.");
        }
    }


    private void validarValorTransferencia(BigDecimal valor) throws ValidationException {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Valor da transferência deve ser maior que zero.");
        }
    }

    private void validarCpfRemetente(PessoaFisicaDto remetenteFisica) throws ValidationException {
        if (CpfValidador.isValid(remetenteFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do remetente inválido.");
        }
    }

    private void validarCpfDestinatario(PessoaFisicaDto destinoFisica) throws ValidationException {
        if (CpfValidador.isValid(destinoFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do destinatário inválido.");
        }
    }

    private void validarCnpjDestinatario(PessoaLojistaDto destinoLojista) throws ValidationException {
        if (!CnpjValidador.isValid(destinoLojista.getPessoaLojistaCnpjDto())) {
            throw new ValidationException("CNPJ do destinatário inválido.");
        }
    }


}

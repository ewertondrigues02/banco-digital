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
        if (cpf == null || cpf.isEmpty()) {
            throw new PessoaNotFoundException("CPF nulo ou vazio, favor tente novamente.");
        }

        cpf = cpf.replace(".", "").replace("-", "");
        if (!CpfValidador.isValid(cpf)) {
            throw new PessoaNotFoundException("CPF inválido. Certifique-se de que o CPF é válido e no formato correto.");
        }

        PessoaFisica pessoaFisica = pessoaFisicaRepository.findByCpf(cpf)
                .orElseThrow(() -> new PessoaNotFoundException("Nenhuma pessoa encontrada para o CPF fornecido."));

        return PessoaFisicaDto.fromEntity(pessoaFisica);
    }


    @Override
    public PessoaFisicaDto depositar(PessoaFisicaDto entity, BigDecimal valor) throws EntityNotFoundException, ValidationException {
        if (!Objects.equals(entity.getPessoaFisicaCpfDto(), pessoaFisicaDestino.getPessoaFisicaCpf()) ||
                !Objects.equals(entity.getPessoaFisicaEmailDto(), pessoaFisicaDestino.getPessoaEmail()) || CpfValidador.isValid(entity.getPessoaFisicaCpfDto())) {
            throw new EntityNotFoundException("Não foi possível fazer o depósito. Verifique os dados novamente.");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Valor inválido, o valor precisa ser maior que 0: " + valor);
        }
        pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));
        pessoaFisicaRepository.save(pessoaFisicaDestino);
        return entity.fromEntity(pessoaFisicaDestino);
    }

    @Override
    public PessoaFisicaDto enviar(PessoaFisicaDto entityRemetenteFisica, PessoaFisicaDto entityDestinoFisica, PessoaLojistaDto entityDestinoLojista, BigDecimal valor, Instant horaTransferencia) throws EntityNotFoundException, ValidationException {

        if (entityRemetenteFisica == null || (entityDestinoFisica == null && entityDestinoLojista == null)) {
            throw new EntityNotFoundException("Remetente ou destinatário inválidos.");
        }

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("O valor da transferência deve ser maior que zero.");
        }

        if (!CpfValidador.isValid(entityRemetenteFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do remetente inválido.");
        }

        if (entityDestinoFisica != null && !CpfValidador.isValid(entityDestinoFisica.getPessoaFisicaCpfDto())) {
            throw new ValidationException("CPF do destinatário inválido.");
        }

        if (entityDestinoLojista != null && !CnpjValidador.isValid(entityDestinoLojista.getPessoaLojistaCnpjDto())) {
            throw new ValidationException("CNPJ do destinatário (Lojista) inválido.");
        }

        if (entityRemetenteFisica.getPessoaFisicaSaldoDto().compareTo(valor) < 0) {
            throw new ValidationException("Saldo insuficiente para a transferência.");
        }

        if (entityDestinoFisica != null) {
            PessoaFisica pessoaFisicaRemetente = pessoaFisicaRepository.findByCpf(entityRemetenteFisica.getPessoaFisicaCpfDto())
                    .orElseThrow(() -> new EntityNotFoundException("Remetente não encontrado."));
            PessoaFisica pessoaFisicaDestino = pessoaFisicaRepository.findByCpf(entityDestinoFisica.getPessoaFisicaCpfDto())
                    .orElseThrow(() -> new EntityNotFoundException("Destinatário não encontrado."));

            pessoaFisicaRemetente.setPessoaSaldo(pessoaFisicaRemetente.getPessoaSaldo().subtract(valor));
            pessoaFisicaDestino.setPessoaSaldo(pessoaFisicaDestino.getPessoaSaldo().add(valor));

            pessoaFisicaRepository.save(pessoaFisicaRemetente);
            pessoaFisicaRepository.save(pessoaFisicaDestino);

            return PessoaFisicaDto.fromEntity(pessoaFisicaRemetente);
        }

        if (entityDestinoLojista != null) {

            if (entityRemetenteFisica.getPessoaFisicaCpfDto() != null) {
                throw new ValidationException("O Lojista (destinatário) não pode ser o remetente.");
            }

            if (entityRemetenteFisica.getPessoaFisicaSaldoDto().compareTo(valor) < 0) {
                throw new ValidationException("Saldo insuficiente para a transferência.");
            }

            PessoaLojista pessoaLojistaDestino = pessoaLojistaRepository.findByCnpj(entityDestinoLojista.getPessoaLojistaCnpjDto())
                    .orElseThrow(() -> new EntityNotFoundException("Destinatário Lojista não encontrado."));

            pessoaLojistaDestino.setPessoaSaldo(pessoaLojistaDestino.getPessoaSaldo().add(valor));

            pessoaLojistaRepository.save(pessoaLojistaDestino);

            return PessoaFisicaDto.fromEntity(pessoaFisicaRemetente);
        }

        throw new ValidationException("Tipo de destinatário inválido.");
    }


}

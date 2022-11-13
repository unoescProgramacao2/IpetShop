package edu.br.unoesc.ipetshop.pets.services;


import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.Servico;
import edu.br.unoesc.ipetshop.pets.repositories.ServicoRepository;
import edu.br.unoesc.ipetshop.util.Phraseology;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.Period.*;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<ServicoDTO> listarTodos() {
        List<ServicoDTO> listaServicosDTO = new ArrayList<>();
        List<Servico> servicos = servicoRepository.findAll();
        servicos.forEach(servico -> {
            ServicoDTO servicoDTO = new ServicoDTO(servico);
            listaServicosDTO.add(servicoDTO);
        });
        return listaServicosDTO;
    }

    public Object buscaServicoPorId(Long id) {
        Servico servico = servicoRepository.findById(id);
        if (servico == null)
            throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_NAO_EXISTENTE);
        return new ServicoDTO(servico);
    }
    @Transactional
    public ServicoDTO salvarNovoServico(ServicoDTO novoServicoDTO) {

        Servico servicoQueVaiSerGravado;
        if (novoServicoDTO.getId() != null) {
            Servico verificaSeExisteServico = servicoRepository.findById(novoServicoDTO.getId());
            if (verificaSeExisteServico != null)
                throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_EXISTENTE);
        }
        servicoQueVaiSerGravado = new Servico();
        return this.registrarServico(servicoQueVaiSerGravado, novoServicoDTO);
    }

    private ServicoDTO registrarServico(Servico servicoQueVaiSerGravado, ServicoDTO servicoDTO) {
        servicoQueVaiSerGravado.setNome(servicoDTO.getNome());
        servicoQueVaiSerGravado.setDescricao(servicoDTO.getDescricao());
        servicoQueVaiSerGravado.setValor(servicoDTO.getValor());
        servicoRepository.save(servicoQueVaiSerGravado);
        servicoDTO.setId(servicoQueVaiSerGravado.getId());
        return servicoDTO;

    }
    public ServicoDTO atualizarServico(ServicoDTO servicoAtualizadoDTO, Long id) {
        Servico servicoQueVaiSerAlterado = servicoRepository.findById(id);
        if (servicoQueVaiSerAlterado == null)
            throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_NAO_EXISTENTE);
        if (validarAlteracao(servicoQueVaiSerAlterado, Phraseology.PRAZO_EM_DIAS_PARA_ALTERACAO))
            throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_NAO_PODE_SER_ALTERADO);
        servicoQueVaiSerAlterado.setDataAtualizacao(LocalDateTime.now());
        return this.registrarServico(servicoQueVaiSerAlterado, servicoAtualizadoDTO);
    }
    public void deletarServico(Long id) {
        Servico servicoQueVaiSerDeletado = servicoRepository.findById(id);
        if (servicoQueVaiSerDeletado == null)
            throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_NAO_EXISTENTE);
        if (validarAlteracao(servicoQueVaiSerDeletado, Phraseology.PRAZO_EM_DIAS_PARA_ALTERACAO))
            throw new RuntimeException(Phraseology.MENSAGEM_SERVICO_NAO_PODE_SER_EXCLUIDO);
        servicoRepository.delete(servicoQueVaiSerDeletado);
    }

    private boolean validarAlteracao(Servico servico, int prazoEmDiasParaAlteracao) {

        Period diff = between(servico.getDataCriacao().toLocalDate(), LocalDate.now());
        return diff.getDays() > prazoEmDiasParaAlteracao;    }



}

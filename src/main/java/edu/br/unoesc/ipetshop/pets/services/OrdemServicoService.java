package edu.br.unoesc.ipetshop.pets.services;

import edu.br.unoesc.ipetshop.pets.dtos.OrdemServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.repositories.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdemServicoService {
    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public List<OrdemServicoDTO> listarTodos() {
        List<OrdemServicoDTO> listaServicosDTO = new ArrayList<>();
        List<OrdemServico> servicos = ordemServicoRepository.findAll();
        servicos.forEach(servico -> {
            OrdemServicoDTO servicoDTO = new OrdemServicoDTO(servico);
            listaServicosDTO.add(servicoDTO);
        });
        return listaServicosDTO;
    }
}

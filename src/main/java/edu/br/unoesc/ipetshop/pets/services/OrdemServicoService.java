package edu.br.unoesc.ipetshop.pets.services;

import edu.br.unoesc.ipetshop.pets.dtos.OrdemServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.repositories.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> getOrdem() {

        List<OrdemServico> ordemServicoList = ordemServicoRepository.findAll();

        return ordemServicoList;

    }
}

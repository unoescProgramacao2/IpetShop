package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.PetsDTO;
import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.repositories.OrdemServicoRepository;
import edu.br.unoesc.ipetshop.pets.services.PetsService;
import edu.br.unoesc.ipetshop.pets.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ordem_servico")
public class OrdemServicoRestController {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    ServicoService servicoService;

    PetsService petsService;

    public int id;

    public OrdemServicoRestController(ServicoService servicoService, PetsService petsService)
    {

        this.servicoService = servicoService;
        this.petsService = petsService;
    }

    @GetMapping("/")
    public List<OrdemServico> buscarTodasOS() {
            return ordemServicoRepository.findAll();
    }

}

package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.PetsDTO;
import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.entities.Servico;
import edu.br.unoesc.ipetshop.pets.repositories.OrdemServicoRepository;
import edu.br.unoesc.ipetshop.pets.services.PetsService;
import edu.br.unoesc.ipetshop.pets.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class OrdemServicoController {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    ServicoService servicoService;

    PetsService petsService;

    public int id;

    public OrdemServicoController(ServicoService servicoService, PetsService petsService)
    {

        this.servicoService = servicoService;
        this.petsService = petsService;
    }

    @GetMapping("/ordem_servicos")
    public List<OrdemServico> buscarTodasOS() {
            return ordemServicoRepository.findAll();
    }

    @GetMapping("/teste")
    public ResponseEntity<Object> buscarTodosTeste() {
        return ResponseEntity.ok(ordemServicoRepository.findAll());
    }


    @GetMapping("/cadastroOS")
    public String cadastroOS(Model servico) {

        List<ServicoDTO> servicoList = new ArrayList<>();

        servico.addAttribute("servico", servicoList);

        List<ServicoDTO> listServicos = servicoService.listarTodos();

        servico.addAttribute("servicos", listServicos);


        List<PetsDTO> petsList = new ArrayList<>();

        servico.addAttribute("pet", petsList);

        List<PetsDTO> listPets = petsService.listarTodos();

        servico.addAttribute("pets", listPets);

        return "OrdemServico/Ordem_cadastro_view";

    }

    @GetMapping("/salvaOS")
    public String salvarOS(OrdemServico ordemServico)
    {
        ordemServicoRepository.save(ordemServico);

        return "OrdemServico/Response_view";
    }

}

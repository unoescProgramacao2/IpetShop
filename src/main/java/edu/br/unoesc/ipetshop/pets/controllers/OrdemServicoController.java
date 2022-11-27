package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.entities.Servico;
import edu.br.unoesc.ipetshop.pets.repositories.OrdemServicoRepository;
import edu.br.unoesc.ipetshop.pets.services.PetsService;
import edu.br.unoesc.ipetshop.pets.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public OrdemServicoController(ServicoService servicoService)
    {
        this.servicoService = servicoService;
    }

    @GetMapping("/ordem_servicos")
    public List<OrdemServico> buscarTodasOS() {
            return ordemServicoRepository.findAll();
    }

    @GetMapping("/cadastroOS")
    public String cadastroOS(Model servico) {

        List<ServicoDTO> servicoUnico = new ArrayList<>();

        servico.addAttribute("servico", servicoUnico);

        List<ServicoDTO> listServicos = servicoService.listarTodos();

        servico.addAttribute("servicos", listServicos);

        return "OrdemServico/Ordem_cadastro_view";

    }

}

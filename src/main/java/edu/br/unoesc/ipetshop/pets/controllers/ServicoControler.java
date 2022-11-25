package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.Servico;
import edu.br.unoesc.ipetshop.pets.repositories.ServicoRepository;
import edu.br.unoesc.ipetshop.pets.services.OrdemServicoService;
import edu.br.unoesc.ipetshop.pets.services.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicoControler {

    ServicoRepository servicoRepository;

    ServicoService servicoService;

    public ServicoControler(ServicoService servicoService)
    {
        this.servicoService = servicoService;
    }


    @GetMapping("/servicos")
    public String servicos() {
        return "servico/servico_view";
    }
    @GetMapping("/servicos/{servicoId}")
    public String servicosDetalhes() {
        return "servico/servico_detalhe_view";
    }
    @GetMapping("/ordem_servico")
    public String ordemServicos() { return "OrdemServico/Ordem_View";}
    @GetMapping("/ordem_servico/cadastro")
    public String cadastroOS(Model servico) {

        List<ServicoDTO> servicoUnico = new ArrayList<>();

        servico.addAttribute("servico", servicoUnico);

        List<ServicoDTO> listServicos = servicoService.listarTodos();

        servico.addAttribute("servicos", listServicos);

        return "OrdemServico/Ordem_cadastro_view";

    }
}

package edu.br.unoesc.ipetshop.pets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicoControler {
    @GetMapping("/servicos")
    public String servicos() {
        return "servico/servico_view";
    }
    @GetMapping("/servicos/{servicoId}")
    public String servicosDetalhes() {
        return "servico/servico_detalhe_view";
    }
    @GetMapping("/ordem_servico")
    public String ordem_servicos() { return "OrdemServico/Ordem_View";}
}

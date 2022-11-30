package edu.br.unoesc.ipetshop.pets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetShopController {

    @GetMapping("/petshop")
    public String petshop(){
        return "/petshop/petshop_view";
    }

    @GetMapping("/petshop/{petshopId}")
    public String petshopDetalhes(){
        return "/petshop/petshop_detalhe_view";
    }

    @GetMapping("/petshop/novo")
    public String novoPetshop(){
        return "/petshop/petshop_novo_view";
    }

}

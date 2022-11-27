package edu.br.unoesc.ipetshop.pets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetsControler {
    @GetMapping("/pets")
    public String pets() {
        return "pets/pets_view";
    }
    @GetMapping("/pets/{petsId}")
    public String petsDetalhes() {
        return "pets/pets_detalhe_view";
    }

    @GetMapping("/pets/novo")
    public String novoPets() {
        return "pets/pets_novo_view";
    }
}

package edu.br.unoesc.ipetshop.pets.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProdutoControler {
    @GetMapping("/produtos")
    public String produtos() {
        return "produto/produto_view";
    }
    @GetMapping("/produtos/{produtoId}")
    public String produtosDetalhes() {
        return "produto/produto_detalhe_view";
    }

    @GetMapping("/produtos/novo")
    public String novoProduto() {
        return "produto/produto_novo_view";
    }

    @GetMapping("/produtos/{produtoId}/delete")
    public String deleteProduto() {
        return "/api/produto/{produtoId}";
    }

}

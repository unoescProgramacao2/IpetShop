package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.ProdutoDTO;
import edu.br.unoesc.ipetshop.pets.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ProdutoRestController {

    final
    ProdutoService produtoService;

    public ProdutoRestController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produtos")
    public ResponseEntity<Object> salvarNovoProduto(@RequestBody @Valid ProdutoDTO novoProdutoDTO) {
        try {
            novoProdutoDTO = produtoService.salvarNovoProduto(novoProdutoDTO);
            return ResponseEntity.ok(novoProdutoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<Object> buscarTodosProdutos() {
        List<ProdutoDTO> listaDeProdutos = produtoService.listarTodos();
        return ResponseEntity.ok(listaDeProdutos);
    }

    @GetMapping("/produtos/{produtoId}")
    public ResponseEntity<Object> buscarProdutoPorId(@PathVariable Long produtoId) {
        try {
            ProdutoDTO produtoDTO = produtoService.buscaProdutoPorId(produtoId);
            return ResponseEntity.ok(produtoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Produto não encontrado");
        }
    }


    @PatchMapping("/produtos")
    public ResponseEntity<Object> atualizarProduto(@RequestBody ProdutoDTO produtoAtualizadoDTO) {
        try {
            produtoAtualizadoDTO = produtoService.atualizarProduto(produtoAtualizadoDTO);
            return ResponseEntity.ok(produtoAtualizadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/produtos/{produtoId}")
    public ResponseEntity<Object> deletarProdutoPorId(@PathVariable Long produtoId) {
        try {
            produtoService.deletarProduto(produtoId);
            return ResponseEntity.ok("Deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

  //  @GetMapping("/produtos/{produtoId}/images/{imageId}")
  //  public ResponseEntity<Object> buscarProdutoPorImageid(@PathVariable Long produtoId) {
  //      try {
   //         ProdutoDTO produtoDTO = produtoService.buscaProdutoPorId(produtoId);
 //           return ResponseEntity.ok(produtoDTO);
  //      }catch (Exception e){
  //          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  //      }
 //  }

//    @GetMapping("/produtos/{produtoId}/images/")
//    public ResponseEntity<Object> buscarProdutoPorImage(@PathVariable Long produtoId) {
 //       try {
 //           ProdutoDTO produtoDTO = produtoService.buscaProdutoPorId(produtoId);
 //           return ResponseEntity.ok(produtoDTO);
  //      }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
 //   }





}

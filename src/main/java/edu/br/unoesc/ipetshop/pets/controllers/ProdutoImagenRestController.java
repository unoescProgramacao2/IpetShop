package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.ImagensDTO;
import edu.br.unoesc.ipetshop.pets.services.ImagenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos/{produtoId}/imagens")
public class ProdutoImagenRestController {
    final
    ImagenService imagenService;

    public ProdutoImagenRestController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> listaImagensDoProduto(@PathVariable Long produtoId) {
        try {
            List<ImagensDTO> imagens = imagenService.listarTodasImagensPorProduto(produtoId);
            return ResponseEntity.ok(imagens);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("/{imagemId}")
    public ResponseEntity<Object> buscaImagemPorProdutoIdEimagemId(@PathVariable Long produtoId,@PathVariable Long imagemId) {
        try {
            ImagensDTO imagensDTO = imagenService.buscaImagenPorId(produtoId,imagemId);
            return ResponseEntity.ok(imagensDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PostMapping("/")
    public ResponseEntity<Object> salvarNovoProduto(@PathVariable Long produtoId,@RequestBody ImagensDTO novaImagemDTO) {
        try {
            novaImagemDTO = imagenService.salvarNovaImagen(produtoId,novaImagemDTO);
            return ResponseEntity.ok(novaImagemDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PatchMapping("/")
    public ResponseEntity<Object> atualizarProduto(@PathVariable Long produtoId,@RequestBody ImagensDTO imagemAtualizadaDTO) {
        try {
            imagemAtualizadaDTO = imagenService.atualizarImagen(produtoId,imagemAtualizadaDTO);
            return ResponseEntity.ok(imagemAtualizadaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @DeleteMapping("/{imagemId}")
    public ResponseEntity<Object> deletarProduto(@PathVariable Long produtoId,@PathVariable Long imagemId) {
        try {
            imagenService.deletarImagen(produtoId,imagemId);
            return ResponseEntity.ok("Imagen deletada com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}


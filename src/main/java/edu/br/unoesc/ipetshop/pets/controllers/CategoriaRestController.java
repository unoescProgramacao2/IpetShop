package edu.br.unoesc.ipetshop.pets.controllers;


import edu.br.unoesc.ipetshop.pets.dtos.CategoriaDTO;
import edu.br.unoesc.ipetshop.pets.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaRestController {

    final
    CategoriaService categoriaService;

    public CategoriaRestController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/novacategoria")
    public ResponseEntity<Object> salvarNovaCategoria(@RequestBody CategoriaDTO novaCategoriaDTO) {
        try{
            novaCategoriaDTO = categoriaService.salvarNovaCategoria(novaCategoriaDTO);
            return ResponseEntity.ok(novaCategoriaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/categorias")
    public ResponseEntity<Object> buscarTodasCategorias() {
        List<CategoriaDTO> listaDeCategorias = categoriaService.listarTodas();
        return ResponseEntity.ok(listaDeCategorias);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<Object> buscarCategoriaPorId(@PathVariable Long categoriaId) {
        try{
            CategoriaDTO categoriaDTO = categoriaService.buscarCategoriaPorId(categoriaId);
            return ResponseEntity.ok(categoriaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @PatchMapping("/categorias")
    public ResponseEntity<Object> atualizarCategoria(@RequestBody CategoriaDTO categoriaAtualizadaDTO) {
        try{
            categoriaAtualizadaDTO = categoriaService.atualizarCategoria(categoriaAtualizadaDTO);
            return ResponseEntity.ok(categoriaAtualizadaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/categorias/{categoriaId}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable Long categoriaId) {
        try{
            categoriaService.deletarCategoria(categoriaId);
            return ResponseEntity.ok("Deletado com suesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.ServicoDTO;
import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import edu.br.unoesc.ipetshop.pets.services.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/servicos")
public class ServicoRestController {

        final
        ServicoService servicoService;

    public ServicoRestController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> buscarTodosServicos() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarServicoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(servicoService.buscaServicoPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/newservice")
    public ResponseEntity<Object> salvarNovoServico(@RequestBody @Valid ServicoDTO novoServicoDTO) {
        try {
            novoServicoDTO = servicoService.salvarNovoServico(novoServicoDTO);
            return ResponseEntity.ok(novoServicoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PatchMapping("/")
    public ResponseEntity<Object> atualizarServico(@RequestBody @Valid ServicoDTO servicoDTO) {
        try {
            servicoDTO = servicoService.atualizarServico(servicoDTO);
            return ResponseEntity.ok(servicoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> atualizarServico(@RequestBody @Valid ServicoDTO servicoAtualizadoDTO, @PathVariable Long id) {
        try {
            servicoAtualizadoDTO = servicoService.atualizarServico(servicoAtualizadoDTO, id);
            return ResponseEntity.ok(servicoAtualizadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarServico(@PathVariable Long id) {
        try {
            servicoService.deletarServico(id);
            return ResponseEntity.ok("Serviço deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.services.OrdemServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/ordem_servicos")
public class OrdemServicoController {

    final
    OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService)
    {
        this.ordemServicoService = ordemServicoService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> buscarTodasOrdens() {return ResponseEntity.ok(ordemServicoService.listarTodos());}


}

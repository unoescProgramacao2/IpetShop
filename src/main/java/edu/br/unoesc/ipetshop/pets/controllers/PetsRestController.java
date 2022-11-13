package edu.br.unoesc.ipetshop.pets.controllers;


import edu.br.unoesc.ipetshop.pets.dtos.PetsDTO;
import edu.br.unoesc.ipetshop.pets.services.PetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pets")
public class PetsRestController {

    private final PetsService petsService;

    public PetsRestController(PetsService petsService) {
        this.petsService = petsService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> buscarTodosPets() {
        return ResponseEntity.ok(petsService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPetPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(petsService.buscarPetPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/newpet")
    public ResponseEntity<Object> salvarNovoPet(@RequestBody @Valid PetsDTO novoPetDTO) {
        try {
            novoPetDTO =  petsService.salvarNovoPet(novoPetDTO);
            return ResponseEntity.ok(novoPetDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> atualizarPet(@RequestBody @Valid  PetsDTO petAtualizadoDTO, @PathVariable Long id) {
        try {
            petAtualizadoDTO = petsService.atualizarPet(petAtualizadoDTO, id);
            return ResponseEntity.ok(petAtualizadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarPet(@PathVariable Long id) {
        try {
            petsService.deletarPet(id);
            return ResponseEntity.ok("Pet deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

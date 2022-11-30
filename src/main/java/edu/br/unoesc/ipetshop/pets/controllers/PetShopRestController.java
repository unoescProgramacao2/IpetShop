package edu.br.unoesc.ipetshop.pets.controllers;

import edu.br.unoesc.ipetshop.pets.dtos.PetShopDTO;
import edu.br.unoesc.ipetshop.pets.services.PetShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/petshop")
public class PetShopRestController {

    private final PetShopService petShopService;

    public PetShopRestController(PetShopService petShopService) {
        this.petShopService = petShopService;
    }

    @PostMapping("/newpetshop")
    public ResponseEntity<Object> salvarNovaPetShop(@RequestBody @Valid PetShopDTO novaPetShopDTO) {
        try{
            novaPetShopDTO = petShopService.salvarNovaPetShop(novaPetShopDTO);
            return ResponseEntity.ok(novaPetShopDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> buscarTodasPetShops() {
        List<PetShopDTO> listaDePetShops = petShopService.listarTodas();
        return ResponseEntity.ok(listaDePetShops);
    }

    @GetMapping("/{petshopId}")
    public ResponseEntity<Object> buscarPetShopPorId(@PathVariable Long petshopId) {
        try{
            return ResponseEntity.ok(petShopService.buscarPetShopPorId(petshopId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<Object> atualizarPetShop(@RequestBody @Valid PetShopDTO petShopAtualizadaDTO) {
        try{
            petShopAtualizadaDTO = petShopService.atualizarPetShop(petShopAtualizadaDTO);
            return ResponseEntity.ok(petShopAtualizadaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/update/{petshopId}")
    public ResponseEntity<Object> atualizarPetShop(@RequestBody @Valid PetShopDTO petShopAtualizadaDTO, @PathVariable Long petshopId) {
        try{
            petShopAtualizadaDTO = petShopService.atualizarPetShop(petShopAtualizadaDTO, petshopId);
            return ResponseEntity.ok(petShopAtualizadaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{petshopId}")
    public ResponseEntity<Object> excluirPetShop(@PathVariable Long petshopId) {
        try{
            petShopService.excluirPetShop(petshopId);
            return ResponseEntity.ok("PetShop excluída com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

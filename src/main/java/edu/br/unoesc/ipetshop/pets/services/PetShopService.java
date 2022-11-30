package edu.br.unoesc.ipetshop.pets.services;

import edu.br.unoesc.ipetshop.pets.dtos.PetShopDTO;
import edu.br.unoesc.ipetshop.pets.entities.PetShop;
import edu.br.unoesc.ipetshop.pets.repositories.PetShopRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetShopService {

    private final PetShopRepository petShopRepository;

    public PetShopService(PetShopRepository petShopRepository) {
        this.petShopRepository = petShopRepository;
    }
    @Transactional
    public PetShopDTO salvarNovaPetShop(PetShopDTO novaPetShopDTO) {
        PetShop petShopQueVaiSerGravado;
        if (novaPetShopDTO.getId() != null) {
            PetShop verificaSeExistePetShop = petShopRepository.findById(novaPetShopDTO.getId());
            if (verificaSeExistePetShop != null)
                throw new RuntimeException("PetShop já existe");
        }
        petShopQueVaiSerGravado = new PetShop();
        return this.registrarPetshop(petShopQueVaiSerGravado, novaPetShopDTO);
    }

    public List<PetShopDTO> listarTodas() {
        List<PetShopDTO> petShopDTOS = new ArrayList<>();
        List<PetShop> petShop = petShopRepository.findAll();
        petShop.forEach(petsShop -> {
            PetShopDTO petShopDTO = new PetShopDTO(petsShop);
            petShopDTOS.add(petShopDTO);
        });
        return petShopDTOS;
    }

    public PetShopDTO buscarPetShopPorId(Long petshopId) {
        PetShop petShop = petShopRepository.findByid(petshopId);
        if (petShop == null)
            throw new RuntimeException("PetShop não encontrada");
        return new PetShopDTO(petShop);
    }

    public PetShopDTO atualizarPetShop(PetShopDTO petShopDTO) {
        PetShop petShopAtualizado = petShopRepository.findByid(petShopDTO.getId());
        if (petShopAtualizado == null)
            throw new RuntimeException("PetShop não encontrada");
        return this.registrarPetshop(petShopAtualizado, petShopDTO);
    }

    private PetShopDTO registrarPetshop(PetShop petShopAtualizado, PetShopDTO petShopDTO) {
        petShopAtualizado.setCnpj(petShopDTO.getCnpj());
        petShopAtualizado.setRazaosocial(petShopDTO.getRazaosocial());
        petShopAtualizado.setNomefantasia(petShopDTO.getNomefantasia());
        petShopAtualizado.setEmail(petShopDTO.getEmail());
        petShopAtualizado.setTelefone(petShopDTO.getTelefone());
        petShopRepository.save(petShopAtualizado);
        petShopDTO.setId(petShopAtualizado.getId());
        return petShopDTO;
    }

    public void excluirPetShop(Long petshopId) {
        PetShop petShop = petShopRepository.findByid(petshopId);
        if (petShop == null)
            throw new RuntimeException("PetShop não encontrada");
        petShopRepository.delete(petShop);
    }

    public PetShopDTO atualizarPetShop(PetShopDTO petShopAtualizadaDTO, Long petshopId) {
        PetShop petShopAtualizado = petShopRepository.findByid(petshopId);
        if (petShopAtualizado == null)
            throw new RuntimeException("PetShop não encontrada");
        petShopAtualizado.setDataAtualizacao(LocalDateTime.now());
        return this.registrarPetshop(petShopAtualizado, petShopAtualizadaDTO);
    }
}

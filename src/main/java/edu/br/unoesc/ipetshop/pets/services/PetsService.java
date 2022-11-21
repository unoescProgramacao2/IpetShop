package edu.br.unoesc.ipetshop.pets.services;

import edu.br.unoesc.ipetshop.pets.dtos.PetsDTO;
import edu.br.unoesc.ipetshop.pets.entities.Pets;
import edu.br.unoesc.ipetshop.pets.repositories.PetsRepositorry;
import edu.br.unoesc.ipetshop.util.Phraseology;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetsService {
    final
    PetsRepositorry petsRepository;

    public PetsService(PetsRepositorry petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<PetsDTO> listarTodos() {
        List<PetsDTO> listaPetsDTO = new ArrayList<>();
        List<Pets> pets = petsRepository.findAll();
        pets.forEach(pet -> {
            PetsDTO petsDTO = new PetsDTO(pet);
            listaPetsDTO.add(petsDTO);
        });
        return listaPetsDTO;
    }

    public Object buscarPetPorId(Long id) {
        Pets pet = petsRepository.findByid(id);
        if (pet == null)
            throw new RuntimeException(Phraseology.MENSAGEM_PET_NAO_EXISTENTE);
        return new PetsDTO(pet);
    }
    @Transactional
    public PetsDTO salvarNovoPet(PetsDTO novoPet) {
        Pets petQueVaiSerGravado;
        if (novoPet.getId() != null) {
            Pets verificaSeExistePet = petsRepository.findByid( novoPet.getId());
            if (verificaSeExistePet != null)
                throw new RuntimeException(Phraseology.MENSAGEM_PET_NAO_EXISTENTE);
        }
        petQueVaiSerGravado = new Pets();
        return this.registrarPet(petQueVaiSerGravado,novoPet);
    }

    private PetsDTO registrarPet(Pets petQueVaiSerGravado, PetsDTO petDTO) {
        petQueVaiSerGravado.setNome(petDTO.getNome());
        petQueVaiSerGravado.setRaca(petDTO.getRaca());
        petQueVaiSerGravado.setEspecie(petDTO.getEspecie());
        petQueVaiSerGravado.setSexo(petDTO.getSexo());
        petQueVaiSerGravado.setCor(petDTO.getCor());
        petQueVaiSerGravado.setResponsavel(petDTO.getResponsavel());
        petQueVaiSerGravado.setPorte(petDTO.getPorte());
        petQueVaiSerGravado.setPeso(petDTO.getPeso());
        petQueVaiSerGravado.setObservacao(petDTO.getObservacao());
        java.sql.Date data = new java.sql.Date(petDTO.getNascimento().getTime());
        petQueVaiSerGravado.setNascimento(data);
        petsRepository.save(petQueVaiSerGravado);
        petDTO.setId(petQueVaiSerGravado.getId());
        return petDTO;
    }
    public PetsDTO atualizarPet(PetsDTO petAtualizadoDTO) {
        Pets petQueVaiSerAtualizado = petsRepository.findByid(petAtualizadoDTO.getId());
        if (petQueVaiSerAtualizado == null)
            throw new RuntimeException(Phraseology.MENSAGEM_PET_NAO_EXISTENTE);
        return this.registrarPet(petQueVaiSerAtualizado,petAtualizadoDTO);
    }
    public PetsDTO atualizarPet(PetsDTO petAtualizadoDTO, Long id) {
        Pets petQueVaiSerAtualizado = petsRepository.findByid(id);
        if (petQueVaiSerAtualizado == null)
            throw new RuntimeException(Phraseology.MENSAGEM_PET_NAO_EXISTENTE);
        petQueVaiSerAtualizado.setDataAtualizacao(LocalDateTime.now());
        return this.registrarPet(petQueVaiSerAtualizado, petAtualizadoDTO);
    }

    public void deletarPet(Long id) {
        Pets petQueVaiSerDeletado = petsRepository.findByid(id);
        if (petQueVaiSerDeletado == null)
            throw new RuntimeException(Phraseology.MENSAGEM_PET_NAO_EXISTENTE);
        petsRepository.delete(petQueVaiSerDeletado);
    }

}

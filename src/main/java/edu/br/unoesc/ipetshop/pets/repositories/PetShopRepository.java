package edu.br.unoesc.ipetshop.pets.repositories;

import edu.br.unoesc.ipetshop.pets.entities.PetShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetShopRepository extends CrudRepository<PetShop, String> {

    PetShop findByid(Long id);
    PetShop findByRazaosocial(String razaoSocial);

    List<PetShop> findAll();

    PetShop findById(Long id);
}


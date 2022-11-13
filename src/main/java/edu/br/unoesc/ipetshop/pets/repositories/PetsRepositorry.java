package edu.br.unoesc.ipetshop.pets.repositories;

import edu.br.unoesc.ipetshop.pets.entities.Pets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepositorry extends CrudRepository<Pets, Long> {

    Pets findByid(Long id);
    Pets findByNome(String nome);

    List<Pets> findAll();
}

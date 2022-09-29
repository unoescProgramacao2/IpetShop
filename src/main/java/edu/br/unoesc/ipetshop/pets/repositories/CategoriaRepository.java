package edu.br.unoesc.ipetshop.pets.repositories;


import edu.br.unoesc.ipetshop.pets.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String> {

    public Categoria findById(Long Id);

    public Categoria findByNome(String nome);
    public List<Categoria> findAll();
}

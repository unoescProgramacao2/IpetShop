package edu.br.unoesc.ipetshop.pets.repositories;


import edu.br.unoesc.ipetshop.pets.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    public Produto findById(Long id);

    public Produto findByNome(String nome);

    public List<Produto> findAll();
}

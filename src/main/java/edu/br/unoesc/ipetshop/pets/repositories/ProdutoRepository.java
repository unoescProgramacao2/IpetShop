package edu.br.unoesc.ipetshop.pets.repositories;


import edu.br.unoesc.ipetshop.pets.entities.Produto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    Produto findById(Long id);

    Produto findByNome(String nome);

    @NotNull List<Produto> findAll();
}

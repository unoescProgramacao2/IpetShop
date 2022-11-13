package edu.br.unoesc.ipetshop.pets.repositories;

import edu.br.unoesc.ipetshop.pets.entities.Servico;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, String> {

    Servico findById(Long id);
    Servico findByNome(String nome);

    @NotNull List<Servico> findAll();

}
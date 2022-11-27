package edu.br.unoesc.ipetshop.pets.repositories;

import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    public List<OrdemServico> findAll();
}

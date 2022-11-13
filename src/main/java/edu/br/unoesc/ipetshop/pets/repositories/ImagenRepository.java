package edu.br.unoesc.ipetshop.pets.repositories;

import edu.br.unoesc.ipetshop.pets.entities.Imagen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface ImagenRepository extends CrudRepository<Imagen, String>  {
@Query("from Imagen imagen where  imagen.produto.id = :produtoId and imagen.id = :id")
Imagen findByProdutoAndId(@Param("produtoId") Long produtoId, @Param("id") Long id);
}

package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagensDTO {

    private Long id;

    private String nome;

    private String urlarquivo;

    private Long produtoId;

    public ImagensDTO(Imagen imagen) {
        super();
        if (imagen.getId()!=null)
            this.id = imagen.getId();
        this.nome = imagen.getNome();
        this.urlarquivo = imagen.getUrlarquivo();
        this.produtoId = imagen.getProduto().getId();
    }
}


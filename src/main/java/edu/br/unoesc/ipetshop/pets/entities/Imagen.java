package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "produto_imagens")
public class Imagen extends  EntidadeAbstrata{

    private String nome;

    private String urlarquivo;

    @ManyToOne
    @JoinColumn(name="produto_id", nullable=false)
    private Produto produto;

    public String getNome() {
        return nome;
    }
}

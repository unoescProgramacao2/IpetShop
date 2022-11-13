package edu.br.unoesc.ipetshop.pets.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto extends  EntidadeAbstrata {

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String descricao;
    @Column(nullable = false, length = 3)
    private String unidade;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, length = 10)
    private Double valor;
    @Column(nullable = false, length = 25)
    private String situacao;

    @ManyToOne
    @JoinColumn(nullable = false, name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Imagen> imagens;

    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    public List<Imagen> getImagens() {
        return imagens;
    }
    public void setImagens(List<Imagen> imagens) {
        this.imagens = imagens;
    }

}

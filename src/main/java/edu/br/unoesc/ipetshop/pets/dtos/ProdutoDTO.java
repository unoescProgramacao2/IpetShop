package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String unidade;
    @NotBlank
    private String marca;
    private Double valor;
    @NotBlank
    private String situacao;
    private Long categoriaId;

    private String categoria;

    public ProdutoDTO(Produto produto) {
        super();
        if (produto.getId() != null) {
            this.id = produto.getId();
            this.nome = produto.getNome();
            this.descricao = produto.getDescricao();
            this.unidade = produto.getUnidade();
            this.marca = produto.getMarca();
            this.valor = produto.getValor();
            this.situacao = produto.getSituacao();
            this.categoriaId = produto.getCategoria().getId();
            this.categoria = produto.getCategoria().getNome();
        }
    }
}

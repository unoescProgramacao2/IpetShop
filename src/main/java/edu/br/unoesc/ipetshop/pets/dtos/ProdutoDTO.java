package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.Produto;

import javax.validation.constraints.NotBlank;


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

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto produto) {
        super();
        if (produto.getId()!=null)
            this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.unidade = produto.getUnidade();
        this.marca = produto.getMarca();
        this.situacao = produto.getSituacao();
        this.categoriaId = produto.getCategoria().getId();
        this.categoria = produto.getCategoria().getNome();

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {this.nome = nome;}
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {this.valor = valor;}
    public String getUnidade() {return unidade;}
    public void setUnidade(String unidade) {this.unidade = unidade;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getSituacao() {return situacao;}
    public void setSituacao(String situacao) {this.situacao = situacao;}
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public Long getCategoriaId() {return categoriaId;}
    public void setCategoriaId(Long categoriaId) {this.categoriaId = categoriaId;}
}

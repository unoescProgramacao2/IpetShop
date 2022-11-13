package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "servico")
public class Servico  extends EntidadeAbstrata{

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String descricao;
    @Column(nullable = false, length = 10)
    private Double valor;
}

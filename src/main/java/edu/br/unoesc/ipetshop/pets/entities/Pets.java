package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pets extends EntidadeAbstrata {

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String especie;
    @Column(nullable = false, length = 100)
    private String raca;
    @Column(nullable = false, length = 20)
    private String sexo;
    @Column(nullable = false, length = 100)
    private String responsavel;
    @Column(nullable = false, length = 100)
    private String cor;
    @Column(nullable = false, length = 100)
    private String porte;
    @Column(nullable = false, length = 20)
    private double peso;
    @Column(nullable = false)
    private Date Nascimento;
    @Column(nullable = false, length = 200)
    private String observacao;

}

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
@Table(name = "petshop")
public class PetShop extends EntidadeAbstrata {

    @Column(nullable = false, length = 20)
    private String cnpj;
    @Column(nullable = false, length = 100)
    private String razaosocial;
    @Column(nullable = false, length = 100)
    private String nomefantasia;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String telefone;
}

package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String IdServico;

    private String IdPet;

    public OrdemServico(String idServico, String idPet, Double valorServico) {
        super();
        IdServico = idServico;
        IdPet = idPet;
        ValorServico = valorServico;
    }

    private Double ValorServico;

    public Double getValorServico() {
        return ValorServico;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setValorServico(Double valorServico) {
        ValorServico = valorServico;
    }

    public String getIdServico() {
        return IdServico;
    }

    public void setIdServico(String idServico) {
        IdServico = idServico;
    }

    public String getIdPet() {
        return IdPet;
    }

    public void setIdPet(String idPet) {
        IdPet = idPet;
    }



}
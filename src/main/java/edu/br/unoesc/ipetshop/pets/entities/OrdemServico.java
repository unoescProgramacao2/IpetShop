package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ordem_servico")
public class OrdemServico {

    @Id
    private Long Id;

    private int IdServico;

    private int IdPet;

    private Double ValorServico;

    public Double getValorServico() {
        return ValorServico;
    }

    public void setValorServico(Double valorServico) {
        ValorServico = valorServico;
    }

    public Long getIdOrdem() {
        return Id;
    }

    public void setIdOrdem(Long id) {
        Id = id;
    }

    public int getIdServico() {
        return IdServico;
    }

    public void setIdServico(int idServico) {
        IdServico = idServico;
    }

    public int getIdPet() {
        return IdPet;
    }

    public void setIdPet(int idPet) {
        IdPet = idPet;
    }
}
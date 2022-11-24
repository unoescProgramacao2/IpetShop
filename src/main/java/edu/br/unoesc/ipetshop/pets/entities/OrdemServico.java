package edu.br.unoesc.ipetshop.pets.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ordem_servico")
public class OrdemServico  extends EntidadeAbstrata{

    @Column(nullable = false, length = 100)
    private int IdOrdem;
    @Column(nullable = false, length = 100)
    private Date DataOrdem;
    @Column(nullable = false, length = 10)
    private int IdServico;
    @Column(nullable = false, length = 10)
    private int IdPet;

    public int getIdOrdem() {
        return IdOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        IdOrdem = idOrdem;
    }

    public Date getDataOrdem() {
        return DataOrdem;
    }

    public void setDataOrdem(Date dataOrdem) {
        DataOrdem = dataOrdem;
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
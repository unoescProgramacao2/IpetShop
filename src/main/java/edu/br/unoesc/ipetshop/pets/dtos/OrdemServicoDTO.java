package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.OrdemServico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrdemServicoDTO {
    private int IdOrdem;
    @NotBlank
    private Date DataOrdem;
    @NotBlank
    private int IdServico;
    @NotNull
    private int IdPet;

    public OrdemServicoDTO(OrdemServico ordemServico) {
        super();
        if (ordemServico.getId() != null) {
            this.IdOrdem = ordemServico.getIdOrdem();
            this.DataOrdem = ordemServico.getDataOrdem();
            this.IdServico = ordemServico.getIdServico();
            this.IdPet = ordemServico.getIdPet();
        }
    }
}

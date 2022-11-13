package edu.br.unoesc.ipetshop.pets.dtos;


import edu.br.unoesc.ipetshop.pets.entities.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Double valor;

    public ServicoDTO(Servico servico) {
        super();
        if (servico.getId() != null) {
            this.id = servico.getId();
            this.nome = servico.getNome();
            this.descricao = servico.getDescricao();
            this.valor = servico.getValor();
        }
    }
}

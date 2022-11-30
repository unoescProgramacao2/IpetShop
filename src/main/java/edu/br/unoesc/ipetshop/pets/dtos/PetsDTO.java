package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.Pets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PetsDTO {

        private Long id;
        @NotBlank
        private String nome;
        @NotBlank
        private String especie;
        @NotBlank
        private String raca;
        @NotBlank
        private String sexo;
        @NotBlank
        private String responsavel;
        @NotBlank
        private String cor;
        @NotBlank
        private String porte;
        @NotBlank
        private String peso;
        @NotNull
        private Date Nascimento;
        @NotBlank
        private String observacao;

        public PetsDTO(Pets pets) {
            super();
            if (pets.getId() != null) {
                this.id = pets.getId();
                this.nome = pets.getNome();
                this.especie = pets.getEspecie();
                this.raca = pets.getRaca();
                this.sexo = pets.getSexo();
                this.responsavel = pets.getResponsavel();
                this.cor = pets.getCor();
                this.porte = pets.getPorte();
                this.peso = pets.getPeso();
                this.Nascimento = pets.getNascimento();
                this.observacao = pets.getObservacao();
            }
        }
}

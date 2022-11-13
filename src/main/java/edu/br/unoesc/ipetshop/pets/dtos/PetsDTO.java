package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.Pets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PetsDTO {

        private Long id;
        private String nome;
        private String especie;
        private String raca;
        private String sexo;
        private String responsavel;
        private String cor;
        private String porte;
        private double peso;
        private Date Nascimento;
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

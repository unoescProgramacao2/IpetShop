package edu.br.unoesc.ipetshop.pets.dtos;

import edu.br.unoesc.ipetshop.pets.entities.PetShop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetShopDTO {

    private Long id;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String razaosocial;
    @NotBlank
    private String nomefantasia;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    
    public PetShopDTO(PetShop petShop) {
        super();
        if (petShop.getId() != null) {
            this.id = petShop.getId();
            this.cnpj = petShop.getCnpj();
            this.razaosocial = petShop.getRazaosocial();
            this.nomefantasia = petShop.getNomefantasia();
            this.email = petShop.getEmail();
            this.telefone = petShop.getTelefone();
        }
    }
}

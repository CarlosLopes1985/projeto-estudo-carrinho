package com.estrelas.carrinho.resources.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDto {

    @NotBlank(message="Preenchimento de nome é obrigatório")
    @Length(min=3, max=120, message="O tamanho deve estar entre 3 e 50 caracteres")
    private String nome;
}

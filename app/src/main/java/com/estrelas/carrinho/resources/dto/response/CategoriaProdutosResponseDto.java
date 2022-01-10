package com.estrelas.carrinho.resources.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutosResponseDto {

    private Integer id;
    private String nome;

    private List<ProdutoResponseDto> produtos = new ArrayList<>();
}

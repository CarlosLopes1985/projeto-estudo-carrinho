package com.estrelas.carrinho.resources.dto.response;

import com.estrelas.carrinho.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutosResponseDto {

    private Integer id;
    private String nome;

    private List<ProdutoDtoResponse> produtos = new ArrayList<>();
}

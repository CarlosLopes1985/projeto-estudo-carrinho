package com.estrelas.carrinho.resources.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPedidoRequestDto {

    private Integer id;
    private Integer quantidade;
}

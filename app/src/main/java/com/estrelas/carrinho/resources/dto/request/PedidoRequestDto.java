package com.estrelas.carrinho.resources.dto.request;

import com.estrelas.carrinho.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {

    private String cpf;

    private List<ItemPedidoRequestDto> itemPedido = new ArrayList<ItemPedidoRequestDto>();

}

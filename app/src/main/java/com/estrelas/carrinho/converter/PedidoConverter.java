package com.estrelas.carrinho.converter;

import com.estrelas.carrinho.entity.Cliente;
import com.estrelas.carrinho.entity.ItemPedido;
import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.entity.enums.PedidosStatus;
import com.estrelas.carrinho.exception.ObjectNotFoundException;
import com.estrelas.carrinho.repository.ClienteRepository;
import com.estrelas.carrinho.repository.ProdutoRepository;
import com.estrelas.carrinho.resources.dto.request.PedidoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoConverter {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido converterPedidoRequestDtoToPedido(PedidoRequestDto ped){

        Pedido pedido = new Pedido(null, LocalDateTime.now());
        Cliente cliente = clienteRepository.findByCpf(ped.getCpf());

        pedido.setCliente(cliente);

        return pedido;
    }

    public List<ItemPedido> converterPedidoRequestDtoToItemPedido(PedidoRequestDto obj, Pedido ped) {

        Produto prod = null;
        ItemPedido ip1 = null;
        List<ItemPedido>itens = new ArrayList<>();

        for (int i = 0; i < obj.getItemPedido().size() ; i++) {

            int idProduto = obj.getItemPedido().get(i).getProduto().getId();

            prod = produtoRepository.findById(idProduto).orElseThrow(()->
                            new ObjectNotFoundException("Objeto não encontrado! Id: "
                                    +idProduto+ "Item Pedido: " +ItemPedido.class));;

            ip1 = new ItemPedido(
                    ped, prod, 0.00, idProduto, valorTotalItemPedido(prod, idProduto));

            ip1.setStatus(PedidosStatus.EMANALISE.getCod());

            itens.add(ip1);
        }
        return itens;
    }

    public Double valorTotalItemPedido(Produto prod, Integer qtde){
        return prod.getPrecoRevenda() * qtde;
    }
}

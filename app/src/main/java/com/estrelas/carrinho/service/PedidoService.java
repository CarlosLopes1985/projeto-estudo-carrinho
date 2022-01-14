package com.estrelas.carrinho.service;

import com.estrelas.carrinho.converter.PedidoConverter;
import com.estrelas.carrinho.entity.ItemPedido;
import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.exception.ObjectNotFoundException;
import com.estrelas.carrinho.repository.ItemPedidoRepository;
import com.estrelas.carrinho.repository.PedidoRepository;
import com.estrelas.carrinho.resources.dto.request.PedidoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoConverter pedidoConverter;

    public Pedido insert(PedidoRequestDto obj) {

        Pedido ped = pedidoConverter.converterPedidoRequestDtoToPedido(obj);
        ped  = pedidoRepository.save(ped);

        List<ItemPedido> item = pedidoConverter.converterPedidoRequestDtoToItemPedido(obj, ped);
        ped.getItens().addAll(item);

        itemPedidoRepository.saveAll(item);

        return ped;
    }

    public Pedido find(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        obj.get().setValorTotalPedido(calcularValorTotalPedido(obj.get().getItens()));
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Double calcularValorTotalPedido(Set<ItemPedido> pedido){

        Double valorTotal = 0.;

        for (ItemPedido ip : pedido) {
            valorTotal += ip.getSubTotal();
        }
        return valorTotal;
    }
//    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
////        UserSS user = UserService.authenticated();
////        if (user == null) {
////            throw new AuthorizationException("Acesso negado");
////        }
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//     //   Cliente cliente =  clienteService.find(user.getId());
//        return repo.findByCliente(cliente, pageRequest);
//    }
}

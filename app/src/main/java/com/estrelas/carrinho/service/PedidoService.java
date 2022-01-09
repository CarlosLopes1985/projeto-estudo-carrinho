package com.estrelas.carrinho.service;

import com.estrelas.carrinho.entity.ItemPedido;
import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.exception.ObjectNotFoundException;
import com.estrelas.carrinho.repository.ItemPedidoRepository;
import com.estrelas.carrinho.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setDataPedido(LocalDateTime.now());
   //     obj.setCliente(clienteService.find(obj.getCliente().getId()));
 //       obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
  //      obj.getPagamento().setPedido(obj);
//        if (obj.getPagamento() instanceof PagamentoComBoleto) {
//            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
//            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
//        }
        obj = pedidoRepository.save(obj);
        //pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPrecoRevenda());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        //emailService.sendOrderConfirmationEmail(obj);
        return obj;
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

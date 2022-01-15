package com.estrelas.carrinho.service;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.Cliente;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void instanciateTestDatabase() throws ParseException {

        Cliente cliente = new Cliente(null,"11792993706");
        Cliente cliente1 = new Cliente(null,"11792993707");
        Cliente cliente2 = new Cliente(null,"11792993708");
        Cliente cliente3 = new Cliente(null,"11792993709");
        Cliente cliente4 = new Cliente(null,"11792993700");

        clienteRepository.saveAll(Arrays.asList(cliente,cliente1,cliente2,cliente3,cliente4));

        Categoria categoria = new Categoria(null,"Escritório");
        Categoria categoria2 = new Categoria(null,"Informatica");

        Produto p1 = new Produto(null, "Computador",2000.);
        Produto p2 = new Produto(null, "Impressora",800.);
        Produto p3 = new Produto(null, "Mouse",50.);

        categoria.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        categoria2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(categoria));
        p2.getCategorias().addAll(Arrays.asList(categoria,categoria2));
        p3.getCategorias().addAll(Arrays.asList(categoria));

        categoriaRepository.saveAll(Arrays.asList(categoria,categoria2));

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

//		Pedido ped1 = new Pedido(null, LocalDateTime.now());
//		Pedido ped2 = new Pedido(null, LocalDateTime.now());
//
//		ped1.setCliente(cliente);
//		ped2.setCliente(cliente);
//
//		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

//		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
//		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
//		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 10, 800.00);
//		ItemPedido ip4 = new ItemPedido(ped2, p1, 30.00, 8, 800.00);
//		ItemPedido ip5 = new ItemPedido(ped2, p3, 00.00, 15, 800.00);
//		ItemPedido ip6 = new ItemPedido(ped2, p1, 50.00, 18, 800.00);
//
//		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
//		ped2.getItens().addAll(Arrays.asList(ip3,ip4,ip5,ip6));
//
//		p1.getItens().addAll(Arrays.asList(ip1));
//		p2.getItens().addAll(Arrays.asList(ip3,ip4,ip5,ip6));
//
//		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5,ip6));

//		Cliente cliente = new Cliente(null,"11792993706");
//		Cliente cliente2 = new Cliente(null,"11792993707");
//
//		clienteRepository.saveAll(Arrays.asList(cliente,cliente2));

    }
}

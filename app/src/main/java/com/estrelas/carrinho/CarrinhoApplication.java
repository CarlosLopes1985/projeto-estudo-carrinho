package com.estrelas.carrinho;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.ItemPedido;
import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.repository.CategoriaRepository;
import com.estrelas.carrinho.repository.ItemPedidoRepository;
import com.estrelas.carrinho.repository.PedidoRepository;
import com.estrelas.carrinho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class CarrinhoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {

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

		Pedido ped1 = new Pedido(null, LocalDateTime.now());
		Pedido ped2 = new Pedido(null, LocalDateTime.now());

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));

		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2));

//		Cliente cliente = new Cliente(null,"11792993706");
//		Cliente cliente2 = new Cliente(null,"11792993707");
//
//		clienteRepository.saveAll(Arrays.asList(cliente,cliente2));

	}
}

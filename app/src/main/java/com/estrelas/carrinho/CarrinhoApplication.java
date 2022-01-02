package com.estrelas.carrinho;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.repository.CategoriaRepository;
import com.estrelas.carrinho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarrinhoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}
//
//	@Autowired
//	private ClienteRepository clienteRepository;
//
	@Autowired
	private ProdutoRepository produtoRepository;
//
//	@Autowired
//	private CompraRepository compraRepository;

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


//		Cliente cliente = new Cliente(null,"11792993706");
//		Cliente cliente2 = new Cliente(null,"11792993707");
//
//		clienteRepository.saveAll(Arrays.asList(cliente,cliente2));
//
//		Produto prod = new Produto(null, "Geladeira",10,1500.);
//		Produto prod2 = new Produto(null, "Fogão",10,1000.);
//
//		produtoRepository.saveAll(Arrays.asList(prod, prod2));
//
//		Compra compra = new Compra(null,10,10000., LocalDateTime.now(),cliente, prod);
//		Compra compra1 = new Compra(null,5, 5000., LocalDateTime.now(),cliente2, prod2);
//
//		compraRepository.saveAll(Arrays.asList(compra,compra1));
//

	}
}

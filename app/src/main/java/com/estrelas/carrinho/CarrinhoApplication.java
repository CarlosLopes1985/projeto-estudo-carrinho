package com.estrelas.carrinho;

import com.estrelas.carrinho.entity.*;
import com.estrelas.carrinho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class CarrinhoApplication{

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}

}

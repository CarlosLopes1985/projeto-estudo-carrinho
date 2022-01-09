package com.estrelas.carrinho.repository;

import com.estrelas.carrinho.entity.Cliente;
import com.estrelas.carrinho.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}

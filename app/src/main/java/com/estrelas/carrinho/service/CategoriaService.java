package com.estrelas.carrinho.service;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria>categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }
}

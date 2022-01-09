package com.estrelas.carrinho.service;

import com.estrelas.carrinho.converter.ProdutoConverter;
import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.repository.CategoriaRepository;
import com.estrelas.carrinho.resources.dto.request.CategoriaRequestDto;
import com.estrelas.carrinho.resources.dto.response.CategoriaProdutosResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private ProdutoConverter produtoConverter;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaProdutosResponseDto findById(Integer id){
        Optional<Categoria>categoria = categoriaRepository.findById(id);

        CategoriaProdutosResponseDto cat = new CategoriaProdutosResponseDto();

        cat.setId(categoria.get().getId());
        cat.setNome(categoria.get().getNome());
        cat.setProdutos(produtoConverter.convertProdutoToProdutoResponse(categoria.get().getProdutos()));

        return cat;
    }

    public Categoria insert(CategoriaRequestDto obj) {
        Categoria cat = new Categoria(null, obj.getNome());
        return categoriaRepository.save(cat);
    }
}

package com.estrelas.carrinho.converter;

import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.resources.dto.response.ProdutoDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoConverter {

    public List<ProdutoDtoResponse>convertProdutoToProdutoResponse(List<Produto> produtos){

        ProdutoDtoResponse produto = null;
        List<ProdutoDtoResponse>prods = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            produto = new ProdutoDtoResponse(produtos.get(i).getId(),produtos.get(i).getNome());

            prods.add(produto);
        }
        return prods;
    }
}

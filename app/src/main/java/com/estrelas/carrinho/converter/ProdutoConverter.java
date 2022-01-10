package com.estrelas.carrinho.converter;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.resources.dto.request.ProdutoRequestDto;
import com.estrelas.carrinho.resources.dto.response.ProdutoResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProdutoConverter {

    public List<ProdutoResponseDto>convertProdutoToProdutoResponse(List<Produto> produtos){

        ProdutoResponseDto produto = null;
        List<ProdutoResponseDto>prods = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            produto = new ProdutoResponseDto(produtos.get(i).getId(),produtos.get(i).getNome());

            prods.add(produto);
        }
        return prods;
    }

    public Produto convertProdutoRequestToProduto(ProdutoRequestDto obj){

        Produto prod = new Produto();

        prod.setNome(obj.getNome());
        prod.setMargemLucro(obj.getMargemLucro());
        prod.setQuantidade(obj.getQuantidade());
        prod.setValorFrete(obj.getValorFrete());
        prod.setValorImpostos(obj.getValorImpostos());
        prod.setPrecoRevenda(obj.getPrecoRevenda());

        List<Categoria>cats = new ArrayList<Categoria>();
        Categoria cat = null;
        for (int i = 0; i < obj.getCategoria().size(); i++) {
            cat = new Categoria(obj.getCategoria().get(i),null);
            cats.add(cat);
        }

        prod.getCategorias().addAll(cats);

        return prod;
    }
}

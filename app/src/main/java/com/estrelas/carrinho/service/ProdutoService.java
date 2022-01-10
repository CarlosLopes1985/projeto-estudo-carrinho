package com.estrelas.carrinho.service;

import com.estrelas.carrinho.converter.ProdutoConverter;
import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.exception.DataIntegrityException;
import com.estrelas.carrinho.exception.ObjectNotFoundException;
import com.estrelas.carrinho.repository.CategoriaRepository;
import com.estrelas.carrinho.repository.ProdutoRepository;
import com.estrelas.carrinho.resources.dto.request.ProdutoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private ProdutoConverter produtoConverter;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto insert(ProdutoRequestDto obj){

        Produto prod = null;

        try {
            prod = repo.save(produtoConverter.convertProdutoRequestToProduto(obj));
        }catch (Exception ex){
             throw new DataIntegrityException("Erro ao relacionar categoria com produto, categoria inexistente", ex);
        }
        return prod;
    }

    public Produto find(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
    }
}

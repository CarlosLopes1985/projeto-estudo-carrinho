package com.estrelas.carrinho.resources;

import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.entity.Produto;
import com.estrelas.carrinho.resources.dto.request.ProdutoRequestDto;
import com.estrelas.carrinho.service.PedidoService;
import com.estrelas.carrinho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoRequestDto obj) {
        Produto prod = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(prod.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

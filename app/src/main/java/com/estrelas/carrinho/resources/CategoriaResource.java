package com.estrelas.carrinho.resources;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.resources.dto.request.CategoriaRequestDto;
import com.estrelas.carrinho.resources.dto.response.CategoriaProdutosResponseDto;
import com.estrelas.carrinho.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/categorias")
@Slf4j
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CategoriaProdutosResponseDto> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoriaService.findById(id));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaRequestDto obj) {
        Categoria catObj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(catObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

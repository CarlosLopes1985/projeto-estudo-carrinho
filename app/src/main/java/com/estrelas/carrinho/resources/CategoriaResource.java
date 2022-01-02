package com.estrelas.carrinho.resources;

import com.estrelas.carrinho.entity.Categoria;
import com.estrelas.carrinho.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/categorias")
@Slf4j
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {

        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

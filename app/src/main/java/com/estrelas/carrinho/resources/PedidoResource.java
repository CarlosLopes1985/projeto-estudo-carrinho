package com.estrelas.carrinho.resources;

import com.estrelas.carrinho.entity.Pedido;
import com.estrelas.carrinho.resources.dto.request.PedidoRequestDto;
import com.estrelas.carrinho.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PedidoRequestDto obj) {

        Pedido ped =  service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(ped.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

//    @RequestMapping(method=RequestMethod.GET)
//    public ResponseEntity<Page<Pedido>> findPage(
//            @RequestParam(value="page", defaultValue="0") Integer page,
//            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
//            @RequestParam(value="orderBy", defaultValue="instante") String orderBy,
//            @RequestParam(value="direction", defaultValue="DESC") String direction) {
//        Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
//        return ResponseEntity.ok().body(list);
//    }
}

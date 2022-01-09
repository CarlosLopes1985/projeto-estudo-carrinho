package com.estrelas.carrinho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy="id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    @Transient
    private Double valorTotalPedido;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Pedido(Integer id, LocalDateTime dataPedido) {
        this.id = id;
        this.dataPedido = dataPedido;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }


}

package com.estrelas.carrinho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(Integer id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }
}
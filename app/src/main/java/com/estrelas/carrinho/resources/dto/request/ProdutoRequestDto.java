package com.estrelas.carrinho.resources.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDto {

    @NotBlank(message="Preenchimento nome obrigatório")
    @Column(unique = true)
    private String nome;
    @NotNull(message="Preenchimento preco obrigatório")
    @JsonProperty(value = "preco")
    private Double precoRevenda;
    @NotNull(message="Preenchimento quantidade obrigatório")
    private Integer quantidade;
    private Double margemLucro;
    private Double valorImpostos;
    private Double valorFrete;
    @NotNull(message="Preenchimento valor  Compra Obrigatório")
    private Double valorCompra;
    private LocalDate dataValidade;

    private List<Integer> categoria = new ArrayList<>();
}

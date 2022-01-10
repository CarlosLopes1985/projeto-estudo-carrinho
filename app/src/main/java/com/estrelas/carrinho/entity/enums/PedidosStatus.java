package com.estrelas.carrinho.entity.enums;

public enum PedidosStatus {

    EMANALISE(1,"EM_ANALISE"),
    APROVADO(2,"APROVADO"),
    RECUSADO(3,"RECUSADO");

    private Integer cod;
    private String descricao;

    private PedidosStatus(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PedidosStatus toEnum(Integer cod) {

        if(cod == null) {
            return null;
        }

        for(PedidosStatus x : PedidosStatus.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id: Inválido: "+cod);
    }


}

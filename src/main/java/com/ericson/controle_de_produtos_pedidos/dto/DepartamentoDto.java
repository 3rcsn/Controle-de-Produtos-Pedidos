package com.ericson.controle_de_produtos_pedidos.dto;

import com.ericson.controle_de_produtos_pedidos.model.DepartamentoEntity;

public class DepartamentoDto {
    private Integer codigo;
    private String descricao;

    public DepartamentoDto(DepartamentoEntity departamentoEntity) {
        this.codigo = departamentoEntity.getCodigo();
        this.descricao = departamentoEntity.getDescricao();
    }
}

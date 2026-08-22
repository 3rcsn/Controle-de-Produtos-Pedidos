package com.ericson.controle_de_produtos_pedidos.dto;

import com.ericson.controle_de_produtos_pedidos.model.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Integer codigo;
    private String descricao;
    private BigDecimal preco;

    public ProdutoDto paraDto(ProdutoEntity produtoEntity) {
        this.codigo = produtoEntity.getCodigo();
        this.descricao = produtoEntity.getDescricao();
        this.preco = produtoEntity.getPreco();

        return this;
    }
}

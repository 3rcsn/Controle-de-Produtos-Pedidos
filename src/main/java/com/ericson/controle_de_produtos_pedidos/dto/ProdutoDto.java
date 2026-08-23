package com.ericson.controle_de_produtos_pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Integer codigo;
    private String descricao;
    private BigDecimal preco;
}

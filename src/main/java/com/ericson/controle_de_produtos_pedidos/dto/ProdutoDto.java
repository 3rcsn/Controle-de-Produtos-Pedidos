package com.ericson.controle_de_produtos_pedidos.dto;

import java.math.BigDecimal;

public record ProdutoDto (Integer codigo, String descricao, BigDecimal preco) {

}

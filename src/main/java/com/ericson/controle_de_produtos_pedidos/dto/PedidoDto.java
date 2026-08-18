package com.ericson.controle_de_produtos_pedidos.dto;

import java.util.Date;

public record PedidoDto(Integer numero, Date data, ProdutoDto produto) {

}

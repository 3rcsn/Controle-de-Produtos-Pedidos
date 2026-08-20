package com.ericson.controle_de_produtos_pedidos.dto;

import java.util.Date;
import java.util.List;

public record PedidoDto(Integer numero, Date data, List<ProdutoPedidoDto> produto) {

}

package com.ericson.controle_de_produtos_pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPedidoDto {
    private Integer numero;
    private Integer codigo;
    private Integer quantidade;
    private BigDecimal precoProduto;
}

package com.ericson.controle_de_produtos_pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PedidoDto {
    private Integer numero;
    private LocalDate data;
    private ProdutoPedidoDto produto;
}



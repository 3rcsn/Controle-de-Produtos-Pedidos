package com.ericson.controle_de_produtos_pedidos.dto;

import com.ericson.controle_de_produtos_pedidos.model.ProdutoPedidoEntity;
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

    public ProdutoPedidoDto(ProdutoPedidoEntity produtoPedidoEntity) {
        this.numero = produtoPedidoEntity.getNumeroPedido();
        this.codigo = produtoPedidoEntity.getCodigoProduto();
        this.quantidade = produtoPedidoEntity.getQuantidade();
        this.precoProduto = produtoPedidoEntity.getPrecoProduto();
    }
}

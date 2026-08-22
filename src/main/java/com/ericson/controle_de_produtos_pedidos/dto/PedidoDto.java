package com.ericson.controle_de_produtos_pedidos.dto;

import com.ericson.controle_de_produtos_pedidos.model.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Integer numero;
    private Date data;
    private List<ProdutoPedidoDto> produto;

    public PedidoDto fromEntity(PedidoEntity pedidoEntity) {
        return new PedidoDto(pedidoEntity.getNumero(), pedidoEntity.getData(), pedidoEntity.getProdutos().stream().map(ProdutoPedidoDto::new).toList());
    }
}



package com.ericson.controle_de_produtos_pedidos.model;

import com.ericson.controle_de_produtos_pedidos.dto.ProdutoPedidoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto_pedido")
@NoArgsConstructor
@Getter
public class ProdutoPedidoEntity {


    @Id
    @GeneratedValue
    private Long id;

    private Integer numero;

    private Integer codigo;

    private Integer quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal precoProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo", nullable = false)
    private List<ProdutoEntity> produtos = new ArrayList<>();

    public ProdutoPedidoEntity(ProdutoPedidoDto produtoPedidoDto) {
        this.numero = produtoPedidoDto.getNumero();
        this.codigo = produtoPedidoDto.getCodigo();
        this.quantidade = produtoPedidoDto.getQuantidade();
        this.precoProduto = produtoPedidoDto.getPrecoProduto();
    }

}

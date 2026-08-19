package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    @Column(precision = 10, scale = 2)
    private BigDecimal precoProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_numero", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo", nullable = false)
    private ProdutoEntity produto;

}

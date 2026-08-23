package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Entity
@Table(name = "produto_pedido")
@AllArgsConstructor
@Getter
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_numero")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_codigo")
    private Produto produto;

    private Integer quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

}

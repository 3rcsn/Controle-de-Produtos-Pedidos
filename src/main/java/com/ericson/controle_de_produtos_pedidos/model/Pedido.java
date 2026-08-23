package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "data", nullable = false)
    private LocalDate data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutoPedido> produtoPedido;

    @Transient
    private BigDecimal totalPedido;

    public Pedido(Integer numero, LocalDate data, List<ProdutoPedido> produto) {
        this.numero = numero;
        this.data = data;
        this.produtoPedido = produto;
    }

}



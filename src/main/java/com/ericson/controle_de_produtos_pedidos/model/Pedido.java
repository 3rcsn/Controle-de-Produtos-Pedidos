package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "data", nullable = false)
    private LocalDate data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutoPedido> produtos;

    @Transient
    private BigDecimal totalPedido;

    public Pedido(Integer numero, LocalDate data, List<ProdutoPedido> produto) {
        this.numero = numero;
        this.data = data;
        this.produtos = produto;
    }

}



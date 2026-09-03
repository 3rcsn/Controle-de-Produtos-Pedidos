package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.beans.BeanUtils;
import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "numero")
    private Integer numero;
    private LocalDate data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutoPedido> produtos;

    @Transient
    private BigDecimal valorTotal;

    public Pedido() {
    }

    public Pedido(Integer numero, LocalDate data, List<ProdutoPedido> produtos, BigDecimal valorTotal) {
        this.numero = numero;
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Pedido(PedidoDto pedidoDto) {
        if (pedidoDto != null && pedidoDto.getProdutos() != null) {
            BeanUtils.copyProperties(pedidoDto, this);
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getTotalPedido() {
        return valorTotal;
    }

    public void setTotalPedido(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}



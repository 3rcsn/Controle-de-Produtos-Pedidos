package com.ericson.controle_de_produtos_pedidos.model;

import com.ericson.controle_de_produtos_pedidos.dto.ProdutoPedidoDto;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Entity
@Table(name = "produto_pedido")
public class  ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "numero", referencedColumnName = "numero")
    private Pedido pedido;

    private Integer codigo;

    private Integer quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Transient
    private BigDecimal precoTotal;

    public ProdutoPedido(ProdutoPedidoDto produtoPedidoDto) {
        if (produtoPedidoDto != null) {
            BeanUtils.copyProperties(produtoPedidoDto, this);
        }
    }

    public ProdutoPedido() {}

    public ProdutoPedido(Pedido pedido, Integer codigo, Integer quantidade, BigDecimal precoUnitario) {
        this.pedido = pedido;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() { return precoTotal; }

    public void setPrecoTotal(BigDecimal precoTotal) { this.precoTotal = precoTotal; }
}

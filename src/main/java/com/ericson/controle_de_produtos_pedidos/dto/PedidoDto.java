package com.ericson.controle_de_produtos_pedidos.dto;

import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDto {
    private Integer numero;
    private LocalDate data;
    private List<ProdutoPedidoDto> produtos;
    private BigDecimal valorTotal;

    public PedidoDto() {}

    public PedidoDto(Integer numero, LocalDate data, List<ProdutoPedidoDto> produtos) {
        this.numero = numero;
        this.data = data;
        this.produtos = produtos;
    }

    public PedidoDto(Pedido pedidoEntidade) {
        if (pedidoEntidade != null && pedidoEntidade.getProdutos() != null) {
            BeanUtils.copyProperties(pedidoEntidade, this);
            this.produtos = pedidoEntidade.getProdutos().stream().map(ProdutoPedidoDto::new).toList();
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<ProdutoPedidoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedidoDto> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}



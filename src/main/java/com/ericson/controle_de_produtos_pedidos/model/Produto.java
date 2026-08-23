package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo", insertable=false, updatable=false)
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "departamento_codigo")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "produto_codigo")
    private ProdutoPedido produtoPedido;

}

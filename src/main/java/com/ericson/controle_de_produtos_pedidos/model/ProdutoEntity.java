package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo", insertable=false, updatable=false)
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;
    private BigDecimal preco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "departamento", joinColumns = @JoinColumn(name = "codigo", nullable = false))
    private DepartamentoEntity departamento;

}

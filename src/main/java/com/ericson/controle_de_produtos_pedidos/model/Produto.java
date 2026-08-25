package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


}

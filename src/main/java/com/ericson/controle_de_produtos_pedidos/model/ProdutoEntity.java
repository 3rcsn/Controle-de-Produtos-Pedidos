package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String descricao;
    private BigDecimal preco;

    @ManyToOne
    private DepartamentoEntity departamento;

}

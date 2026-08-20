package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String descricao;

}

package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departamento")
@Getter
@Setter
public class Departamento {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Produto> produtos;

}
package com.ericson.controle_de_produtos_pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartamentoEntity {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String descricao;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProdutoEntity> produtos;

}
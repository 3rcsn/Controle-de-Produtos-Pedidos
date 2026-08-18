package com.ericson.controle_de_produtos_pedidos.model;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private Date data;
    @OneToMany
    private ProdutoEntity produtoEntity;

    public PedidoEntity(PedidoDto pedidoDto) {
        this.numero = pedidoDto.numero();
        this.data = pedidoDto.data();
    }
}



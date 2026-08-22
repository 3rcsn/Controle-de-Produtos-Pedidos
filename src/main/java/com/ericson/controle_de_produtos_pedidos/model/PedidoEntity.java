package com.ericson.controle_de_produtos_pedidos.model;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private Date data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoPedidoEntity> produtos = new ArrayList<>();

    public PedidoEntity(PedidoDto pedidoDto) {
        this.numero = pedidoDto.getNumero();
        this.data = pedidoDto.getData();
        this.produtos = pedidoDto.getProduto().stream().map(ProdutoPedidoEntity::new).toList();
    }

}



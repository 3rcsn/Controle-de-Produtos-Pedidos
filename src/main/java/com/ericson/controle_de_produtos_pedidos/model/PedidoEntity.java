package com.ericson.controle_de_produtos_pedidos.model;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private Date data;

    @OneToMany(mappedBy = "pedido_numero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoPedido> produtos = new ArrayList<>();

    public PedidoEntity(PedidoDto pedidoDto) {
        this.numero = pedidoDto.numero();
        this.data = pedidoDto.data();
    }
}



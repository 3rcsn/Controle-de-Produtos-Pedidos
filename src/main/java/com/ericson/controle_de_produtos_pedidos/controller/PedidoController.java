package com.ericson.controle_de_produtos_pedidos.controller;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> inserir (@RequestBody PedidoDto pedido) {

        PedidoDto novoPedido = pedidoService.inserir(pedido);

        return ResponseEntity.ok(novoPedido);

    }

    @PutMapping
    public ResponseEntity<?> atualizar (@RequestBody PedidoDto pedido) {

        PedidoDto pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);

    }

    @PatchMapping
    @Param()
    public ResponseEntity<PedidoDto> atualizarParcialmente (@RequestBody PedidoDto pedido) {


        return ResponseEntity.ok(pedido);
    }

}

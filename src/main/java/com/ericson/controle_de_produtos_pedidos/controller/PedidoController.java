package com.ericson.controle_de_produtos_pedidos.controller;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @PostMapping("inserir")
    public ResponseEntity<PedidoDto> inserirPedido (@RequestBody PedidoDto pedido) {

        PedidoDto novoPedido = pedidoService.inserirPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);

    }

    @PostMapping("inserir-lista")
    public ResponseEntity<List<PedidoDto>> inserirPedidos (@RequestBody List<PedidoDto> pedidos) {

        List<PedidoDto> novosPedidos = pedidoService.inserirPedidos(pedidos);

        return ResponseEntity.status(HttpStatus.CREATED).body(novosPedidos);

    }

    @Autowired
    PedidoService pedidoService;

    @PutMapping
    public ResponseEntity<PedidoDto> atualizar (@RequestBody PedidoDto pedido) {

        PedidoDto pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);

    }

    @PatchMapping
    public ResponseEntity<PedidoDto> atualizarParcialmente (@RequestBody PedidoDto pedido) {

        PedidoDto pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);
    }

    /*@DeleteMapping
    public ResponseEntity<PedidoDto> excluir (@RequestBody PedidoDto pedido) {

    }*/

}

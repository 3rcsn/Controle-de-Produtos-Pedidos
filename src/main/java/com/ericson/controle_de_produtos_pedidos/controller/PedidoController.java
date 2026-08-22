package com.ericson.controle_de_produtos_pedidos.controller;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

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

    @DeleteMapping
    public ResponseEntity<PedidoDto> excluir (@RequestBody PedidoDto pedido) {




        return  ResponseEntity.ok(pedido);
    }

    @GetMapping("busca-por-id")
    public ResponseEntity<PedidoDto> getPedidoPorId(@RequestParam Integer codigo) {

        PedidoDto pedido = pedidoService.getPedidoPorId(codigo);
        return ResponseEntity.ok(pedido);

    }

    @GetMapping("busca-por-periodo")
    public ResponseEntity<List<PedidoDto>> getPedidos(@RequestParam LocalDate dataInicial, LocalDate dataFinal) {

        List<PedidoDto> pedidos = pedidoService.getPedidosPorPeriodo(dataInicial, dataFinal);
        return ResponseEntity.ok(pedidos);

    }

}

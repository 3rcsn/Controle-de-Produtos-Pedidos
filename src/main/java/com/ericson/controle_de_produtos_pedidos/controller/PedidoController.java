package com.ericson.controle_de_produtos_pedidos.controller;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import com.ericson.controle_de_produtos_pedidos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("inserir")
    public ResponseEntity<Pedido> inserirPedido (@RequestBody Pedido pedido) {

        Pedido novoPedido = pedidoService.inserirPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);

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
    public ResponseEntity<Pedido> getPedidoPorId(@RequestParam Integer codigo) {

        Pedido pedido = pedidoService.getPedidoPorId(codigo);
        return ResponseEntity.ok(pedido);

    }

    @GetMapping("busca-por-periodo")
    public ResponseEntity<List<Pedido>> getPedidos(@RequestParam LocalDate dataInicial, LocalDate dataFinal) {

        List<Pedido> pedidos = pedidoService.getPedidosPorPeriodo(dataInicial, dataFinal);
        return ResponseEntity.ok(pedidos);

    }

}

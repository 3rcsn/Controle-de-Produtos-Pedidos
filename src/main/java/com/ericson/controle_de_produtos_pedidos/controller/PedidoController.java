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
    public ResponseEntity<Pedido> atualizar (@RequestBody Pedido pedido) {

        Pedido pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);

    }

    @PatchMapping
    public ResponseEntity<Pedido> atualizarParcialmente (@RequestBody Pedido pedido) {

        Pedido pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping
    public ResponseEntity<PedidoDto> excluir (@RequestBody PedidoDto pedido) {
        return  ResponseEntity.ok(pedido);
    }

    @GetMapping("busca-por-id/{codigo}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Integer codigo) {

        Pedido pedido = pedidoService.consultarPorId(codigo);
        return ResponseEntity.ok(pedido);

    }

    @GetMapping("busca-por-periodo/{dataInicial}/{dataFinal}")
    public ResponseEntity<List<Pedido>> getPedidos(@PathVariable LocalDate dataInicial, LocalDate dataFinal) {

        List<Pedido> pedidos = pedidoService.getPedidosPorPeriodo(dataInicial, dataFinal);
        return ResponseEntity.ok(pedidos);

    }

}

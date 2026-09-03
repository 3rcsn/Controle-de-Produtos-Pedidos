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
    public ResponseEntity<PedidoDto> inserir (@RequestBody PedidoDto pedido) {

        PedidoDto novoPedido = pedidoService.inserirPedidoDto(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);

    }

    @PutMapping("atualizar")
    public ResponseEntity<PedidoDto> atualizar (@RequestBody PedidoDto pedido) {

        PedidoDto pedidoAtualizado = pedidoService.atualizar(pedido);

        return ResponseEntity.ok(pedidoAtualizado);

    }

    @PatchMapping("atualizar-parcialmente")
    public ResponseEntity<PedidoDto> atualizarParcialmente (@RequestBody PedidoDto pedido) {
        return ResponseEntity.ok(pedidoService.atualizar(pedido));
    }

    @DeleteMapping("excluir")
    public ResponseEntity<PedidoDto> excluir (@RequestBody PedidoDto pedido) {
        return  ResponseEntity.ok(pedido);
    }

    @GetMapping("busca-por-id/{numero}")
    public ResponseEntity<PedidoDto> getPedidoPorId(@PathVariable Integer numero) {
        return ResponseEntity.ok(pedidoService.consultarPorId(numero));

    }

    @GetMapping("busca-por-periodo/{dataInicial}/{dataFinal}")
    public ResponseEntity<List<PedidoDto>> getPedidos(@PathVariable LocalDate dataInicial, LocalDate dataFinal) {
        return ResponseEntity.ok(pedidoService.getPedidosPorPeriodo(dataInicial, dataFinal));

    }

}

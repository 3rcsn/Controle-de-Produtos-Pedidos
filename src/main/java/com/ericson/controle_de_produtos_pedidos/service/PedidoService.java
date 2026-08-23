package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import com.ericson.controle_de_produtos_pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido inserirPedido (Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Pedido pedidoAtualizado) {
        pedidoRepository.findById(pedidoAtualizado.getNumero())
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return pedidoRepository.save(pedidoAtualizado);
    }

    public void excluir(Integer numero) {
        pedidoRepository.deleteById(numero);
    }

    public Pedido consultarPorId(Integer numero) {
        return pedidoRepository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> getPedidosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal){

        return pedidoRepository.buscarPorPeriodo(dataInicial, dataFinal)
                .stream().toList();

    }

}

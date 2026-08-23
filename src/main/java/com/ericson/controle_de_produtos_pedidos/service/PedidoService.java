package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
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

    public PedidoDto atualizar (PedidoDto pedidoDto) {
       //PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoDto.getNumero())
       //        .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
       return pedidoDto;
    }

    public Pedido getPedidoPorId(Integer codigo){

        return pedidoRepository.getReferenceById(codigo);


    }

    public List<Pedido> getPedidosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal){

        return pedidoRepository.buscarPorPeriodo(dataInicial, dataFinal)
                .stream().toList();

    }

}

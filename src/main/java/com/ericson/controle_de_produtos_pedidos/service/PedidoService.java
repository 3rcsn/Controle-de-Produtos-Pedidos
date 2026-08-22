package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.model.PedidoEntity;
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


    public PedidoDto inserirPedido (PedidoDto pedidoDto) {
        PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);
        pedidoRepository.save(pedidoEntity);
        return pedidoDto;
    }

    public List<PedidoDto> inserirPedidos (List<PedidoDto> pedidosDto) {
        List<PedidoEntity> pedidoEntities = converterParaEntidades(pedidosDto);
        pedidoRepository.saveAll(pedidoEntities);
        return pedidosDto;
    }

    public PedidoDto atualizar (PedidoDto pedidoDto) {
       //PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoDto.getNumero())
       //        .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
       return pedidoDto;
    }

    public List<PedidoEntity> converterParaEntidades(List<PedidoDto> pedidosDto) {
        if (pedidosDto == null) {
            return null;
        }
        return pedidosDto.stream()
                .map(PedidoEntity::new)
                .toList();
    }

    public PedidoDto getPedidoPorId(Integer codigo){

        PedidoDto pedido = new PedidoDto();

        pedido.fromEntity(pedidoRepository.getReferenceById(codigo));

        return pedido;

    }

    public List<PedidoDto> getPedidosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal){

        List<PedidoEntity> pedidos = pedidoRepository.buscarPorPeriodo(dataInicial, dataFinal)
                .stream().toList();

        return pedidos.stream().map(
                pedidoEntity -> {
                    PedidoDto pedido = new PedidoDto();
                    return pedido.fromEntity(pedidoEntity);
                }
        ).toList();

    }

}

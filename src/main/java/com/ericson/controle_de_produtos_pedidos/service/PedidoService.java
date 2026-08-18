package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.model.PedidoEntity;
import com.ericson.controle_de_produtos_pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoDto inserir (PedidoDto pedidoDto) {

        PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);

        pedidoRepository.save(pedidoEntity);

        return pedidoDto;

    }

    public PedidoDto atualizar (PedidoDto pedidoDto) {

        PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);

        pedidoRepository.buscarPorId()

       return pedidoDto;

    }

}

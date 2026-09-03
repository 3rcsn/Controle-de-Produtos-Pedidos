package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.dto.PedidoDto;
import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import com.ericson.controle_de_produtos_pedidos.model.ProdutoPedido;
import com.ericson.controle_de_produtos_pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoDto inserirPedidoDto (PedidoDto pedidoDto) {

        if (pedidoRepository.findById(pedidoDto.getNumero()).isPresent()) {
            throw new RuntimeException("Pedido já criado");
        }

        return new PedidoDto(pedidoRepository.save(ajustarAtributosProdutosPedido(pedidoDto)));
    }

    public PedidoDto atualizar(PedidoDto pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(pedidoAtualizado.getNumero())
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return new PedidoDto(pedidoRepository.save(pedido));
    }

    public void excluir(Integer numero) {
        pedidoRepository.deleteById(numero);
    }

    public PedidoDto consultarPorId(Integer numero) {

        Pedido pedidoEntidade = pedidoRepository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PedidoDto pedidoDto = new PedidoDto(pedidoEntidade);

        pedidoDto.setValorTotal(calcularValorTotalPedido(pedidoDto));

        return new PedidoDto(pedidoEntidade);

    }

    public List<PedidoDto> getPedidosPorPeriodo(LocalDate dataInicial, LocalDate dataFinal){

        List<PedidoDto> pedidos = pedidoRepository.buscarPorPeriodo(dataInicial, dataFinal)
                .stream().map(PedidoDto::new).toList();

        pedidos.forEach(pedidoDto -> {
            pedidoDto.setValorTotal(calcularValorTotalPedido(pedidoDto));
        });

        return pedidos;

    }

    private BigDecimal calcularValorTotalPedido(PedidoDto pedido) {

        BigDecimal valorTotal = new BigDecimal(0);

        pedido.getProdutos().forEach(produtoPedidoDto -> {
            valorTotal.add(produtoPedidoDto.getPrecoTotal());
        });

        return valorTotal;
    }

    private Pedido ajustarAtributosProdutosPedido(PedidoDto pedidoDto) {

        Pedido pedidoEntidade = new Pedido(pedidoDto);

        List<ProdutoPedido> produtosAux = new ArrayList<>();

        pedidoDto.getProdutos().stream().forEach(produtoPedidoDto -> {
            ProdutoPedido produtoPedido = new ProdutoPedido(produtoPedidoDto);
            produtoPedido.setPedido(pedidoEntidade);
            produtosAux.add(produtoPedido);
        });

        pedidoEntidade.setProdutos(produtosAux);

        return pedidoEntidade;

    }

}

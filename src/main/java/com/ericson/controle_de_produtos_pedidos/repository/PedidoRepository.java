package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query(value = """
            SELECT
                pedido.numero as numero,
                pedido.data as data,
                produto.codigo as codigo,
                produto.descricao as descricao,
                produto_pedido.quantidade as quantidade,
                produto_pedido.preco as preco
            FROM pedido pedido
                JOIN produto_pedido produto_pedido ON (pedido.numero = produto_pedido.numero)
                JOIN produto produto ON (produto_pedido.codigo = produto.codigo)
            WHERE Date(pedido.data) BETWEEN :dataInicial and :dataFinal
            ORDER BY
                pedido.numero, produto.codigo
            """,  nativeQuery = true)
    List<Pedido> buscarPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

}

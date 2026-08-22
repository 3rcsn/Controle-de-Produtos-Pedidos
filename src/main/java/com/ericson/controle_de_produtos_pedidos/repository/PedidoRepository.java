package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    @Query(value = """
            SELECT
                p.numero as numero,
                p.data as data,
                p.codigo as codigo,
                p.descricao as descricao,
                pp.quantidade as quantidade,
                (pp.quantidade * pp.preco_produto) as total_item
            FROM pedido p
                JOIN produto_pedido pp ON (p.numero = pp.numero)
                JOIN produto prod ON (pp.codigo = prod.codigo)
            WHERE p.data BETWEEN :dataInicial and :dataFinal
            ORDER BY
                p.numero, prod.codigo
            """,  nativeQuery = true)
    List<PedidoEntity> buscarPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

}

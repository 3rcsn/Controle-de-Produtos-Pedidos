package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    @Query(value = """
            SELECT
                p.numero,
                p.data,
                pp.codigo_produto,
                prod.descricao,
                pp.quantidade,
                (pp.quantidade * pp.preco_produto) as total_item
            FROM PEDIDO p
                JOIN PRODUTO_PEDIDO pp ON (p.numero = pp.pedido_numero)
                JOIN PRODUTO prod ON (pp.codigo_produto = p.codigo)
            WHERE p.data BETWEEN ?1 and ?2
            ORDER BY
             p.numero, pp.codigo_produto
            """,  nativeQuery = true)
    List<PedidoEntity> buscarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);

}

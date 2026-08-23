package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.Departamento;
import com.ericson.controle_de_produtos_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query(value = """
            SELECT
                departamento.codigo as codigo_departamento,
                produto.codigo as codigo_produto,
                produto.descricao as descricao,
                produto_pedido.quantidade as quantidade,
                produto_pedido.preco_produto as preco
            FROM departamento departamento
                JOIN produto produto ON (produto_pedido.codigo = departamento.codigo)
            WHERE pedido.data BETWEEN :dataInicial and :dataFinal
            ORDER BY
                pedido.numero, produto.codigo
            """,  nativeQuery = true)
    List<Pedido> buscarPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

}

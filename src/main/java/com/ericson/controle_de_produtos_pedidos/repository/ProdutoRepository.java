package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = """
        SELECT p.codigo, p.descricao, p.preco
        FROM PRODUTO p
        WHERE p.id NOT IN (SELECT DISTINCT codigo FROM produto_pedido)
        ORDER BY p.descricao ASC
        """, nativeQuery = true)
    List<Produto> listarProdutosSemPedido();



}
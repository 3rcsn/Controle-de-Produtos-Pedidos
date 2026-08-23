package com.ericson.controle_de_produtos_pedidos.repository;

import com.ericson.controle_de_produtos_pedidos.model.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {}
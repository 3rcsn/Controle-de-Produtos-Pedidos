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
        SELECT d.codigo, d.descricao, p.codigo, p.descricao
        FROM DEPARTAMENTO d
        JOIN PRODUTO p ON d.id = p.departamento_id
        WHERE d.codigo BETWEEN :codInicio AND :codFim
        ORDER BY d.codigo ASC, p.descricao ASC
        """, nativeQuery = true)
    List<Departamento> listarDepartamentoProdutos(@Param("codInicio") Integer codInicio,
                                                     @Param("codFim") Integer codFim);

}

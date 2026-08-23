package com.ericson.controle_de_produtos_pedidos.service;

import com.ericson.controle_de_produtos_pedidos.model.Produto;
import com.ericson.controle_de_produtos_pedidos.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutosSemPedido() {
        return repository.listarProdutosSemPedido();
    }

}

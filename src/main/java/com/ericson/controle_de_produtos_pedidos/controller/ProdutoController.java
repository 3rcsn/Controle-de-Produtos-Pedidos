package com.ericson.controle_de_produtos_pedidos.controller;

import com.ericson.controle_de_produtos_pedidos.model.Produto;
import com.ericson.controle_de_produtos_pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/sem-pedido")
    public ResponseEntity<List<Produto>> listarSemVinculo() {
        return ResponseEntity.ok(service.listarProdutosSemPedido());
    }



}

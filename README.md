# Controle-de-Produtos-Pedidos

Documentação da API Controle de Produtos/Pedidos – Desafio Klab

▎ Escopo: Este documento descreve os endpoints expostos pelo PedidoController. Todos os endpoints são RESTful e retornam objetos JSON formatados pelo Spring Boot.

Para executar a aplicação certificar-se que a engine do Docker esta sendo executada, após isso basta executar a aplicação ControleDeProdutosPedidosApplication ou o comando docker compose up na raiz do projeto. 

A aplicação popula automaticamente a tabela departamento e produto com os valores contidos em /src/main/resources/import.sql 

Para conexão externa via pgadmin utilizar o endereço localhost:5432 com usuário klab e senha secret. 

  ---
Base Path

http://localhost:8080/api/pedido
▎ Substitua <porta> pela porta configurada no docker compose (default: 8080).

~~~~
  ---
Endpoints

┌────────┬──────────────────────────────────────────────┬──────────────────────────────────────────┬────────────────────┬────────────────────┬─────────────┐
│ Método │                   Caminho                    │                Descrição                 │    Request Body    │   Response Body    │ Status HTTP │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ POST   │ /inserir                                     │ Inserir um novo pedido                   │ model/Pedido.java  │ dto/PedidoDto.java │ 201 Created │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ PUT    │ /atualizar                                   │ Atualizar um pedido completo             │ model/Pedido.java  │ dto/PedidoDto.java │ 200 OK      │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ PATCH  │ /atualizar-parcialmente                      │ Atualizar parcialmente um pedido         │ model/Pedido.java  │ dto/PedidoDto.java │ 200 OK      │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ DELETE │ /excluir                                     │ Excluir um pedido                        │ dto/PedidoDto.java │ dto/PedidoDto.java │ 200 OK      │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ GET    │ /busca-por-id/{codigo}                       │ Consultar um pedido pelo seu código (ID) │ —                  │ dto/PedidoDto.java │ 200 OK      │
├────────┼──────────────────────────────────────────────┼──────────────────────────────────────────┼────────────────────┼────────────────────┼─────────────┤
│ GET    │ /busca-por-periodo/{dataInicial}/{dataFinal} │ Listar pedidos dentro de um período      │ —                  │ List<PedidoDto>    │ 200 OK      │
└────────┴──────────────────────────────────────────────┴──────────────────────────────────────────┴────────────────────┴────────────────────┴─────────────┘

  ---
~~~~

Exemplos de Chamadas

1. Inserir novo pedido

POST /api/pedido/inserir
Content-Type: application/json

{
"numero": 6,
"data": "2026-08-23" ,
"produtos": [
{
"codigo": 1,
"descricao": "Tilápia",
"quantidade": 2,
"preco": 10.99,
"departamento_codigo": 1
}
]
}

Resposta (201 Created)
{
"data": "2026-08-23",
"numero": 6,
"produtos": [
{
"id": 1,
"pedido": null,
"preco": 10.99,
"produto": null,
"quantidade": 2
}
],
"totalPedido": null
}

2. Excluir pedido

DELETE /api/pedido
Content-Type: application/json

{
"id": 123
}
Resposta (200 OK) – devolve o PedidoDto que foi excluído.

~~~~
3. Buscar por ID

GET /api/pedido/busca-por-id/123
Accept: application/json
Resposta (200 OK) – objeto Pedido.

4. Buscar por período

GET /api/pedido/busca-por-periodo/2026-08-01/2026-08-31
Accept: application/json
Resposta (200 OK) – lista de Pedido cujo dataPedido está entre as duas datas inclusive.

  ---
Erros comuns

┌───────────────────────────┬──────────────────────────────────────────────────────────────────────┬───────────────────────────────────────────────────────────────────────────┐
│          Código           │                               Situação                               │                                 Descrição                                 │
├───────────────────────────┼──────────────────────────────────────────────────────────────────────┼───────────────────────────────────────────────────────────────────────────┤
│ 400 Bad Request           │ Payload inválido ou campos ausentes                                  │ O JSON não corresponde ao modelo esperado ou contém valores fora do tipo. │
├───────────────────────────┼──────────────────────────────────────────────────────────────────────┼───────────────────────────────────────────────────────────────────────────┤
│ 404 Not Found             │ ID inexistente                                                       │ Não foi encontrado nenhum pedido com o numero informado.                  │
├───────────────────────────┼──────────────────────────────────────────────────────────────────────┼───────────────────────────────────────────────────────────────────────────┤
│ 409 Conflict              │ Conflito de negócio (ex.: tentativa de excluir pedido já finalizado) │ Implementado na camada de serviço e propagado ao controlador.             │
├───────────────────────────┼──────────────────────────────────────────────────────────────────────┼───────────────────────────────────────────────────────────────────────────┤
│ 500 Internal Server Error │ Erro inesperado no serviço                                           │ Indica falha interna; verifique logs para detalhes.                       │
└───────────────────────────┴──────────────────────────────────────────────────────────────────────┴───────────────────────────────────────────────────────────────────────────┘

  ---
~~~~
### Atividade 5

Utilizando a base de dados do projeto Ravin, construa as seguintes queries:

1. Liste os produtos em ordem crescente de preço de venda;
2. Liste as mesas em ordem decrescente de quantidade máxima de pessoas;
3. Liste os clientes em ordem alfabética de nome;
4. Liste as comandas em ordem crescente de valor;
5. Liste os status de comanda em ordem alfabética de nome.
6. Liste os 5 produtos mais caros em ordem decrescente de preço de venda;
7. Liste as comandas dos clientes a partir da terceira comanda, em ordem alfabética de código;
8. Liste as mesas com a quantidade máxima de pessoas maior que 4, em ordem crescente de número, mostrando apenas os 3 primeiros resultados;
9. Liste os produtos ativos em ordem alfabética de nome, a partir do sexto produto, mostrando apenas os 4 primeiros resultados;
10. Liste as comandas com valor acima de 100 em ordem decrescente de valor, mostrando apenas os 2 primeiros resultados;


### Resposta

-- Liste os produtos em ordem crescente de preço de venda;
SELECT * FROM produto p ORDER BY p.precovenda ASC;
-- Liste as mesas em ordem decrescente de quantidade máxima de pessoas;
SELECT * FROM mesa m ORDER BY m.quantidademaximapessoas DESC;
-- Liste os clientes em ordem alfabética de nome;
SELECT * FROM pessoa p ORDER BY p.nome ASC;
-- Liste as comandas em ordem crescente de valor;
SELECT * FROM comanda c ORDER BY c.valor ASC;
-- Liste os status de comanda em ordem alfabética de nome.
SELECT * FROM statuscomanda s ORDER BY s.nome;
-- Liste os 5 produtos mais caros em ordem decrescente de preço de venda;
SELECT * FROM produto p ORDER BY p.precovenda DESC LIMIT 5;
-- Liste as comandas dos clientes a partir da terceira comanda, em ordem alfabética de código;
SELECT * FROM comanda c ORDER BY c.codigo ASC OFFSET 2;
-- Liste as mesas com a quantidade máxima de pessoas maior que 4, em ordem crescente de número, mostrando apenas os 3 primeiros resultados;
SELECT * FROM mesa m WHERE m.quantidademaximapessoas > 4 ORDER BY m.numero ASC LIMIT 3;
-- Liste os produtos ativos em ordem alfabética de nome, a partir do sexto produto, mostrando apenas os 4 primeiros resultados;
SELECT * FROM produto p WHERE p.ativo IS TRUE ORDER BY p.nome ASC LIMIT 4 OFFSET 5;
-- Liste as comandas com valor acima de 100 em ordem decrescente de valor, mostrando apenas os 2 primeiros resultados;
SELECT * FROM comanda c WHERE c.valor > 100 ORDER BY c.valor DESC LIMIT 2;

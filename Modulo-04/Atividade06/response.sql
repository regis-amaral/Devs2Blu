--### Atividade 6
--Utilizando a base de dados do projeto Ravin, construa as seguintes queries:
--1. Calcule o valor total das comandas;
SELECT sum(c.valor) AS "Valor Total das Comandas" FROM comanda c;
--2. Obtenha o preço de venda máximo dos produtos;
SELECT max(p.precovenda) AS "Maior Preço de Venda" FROM produto p;
--3. Encontre o tempo de preparo mínimo dos produtos;
SELECT MIN(p.tempodepreparo) AS "Tempo de Preparo Mínimo" FROM produto p;
--4. Calcule a média dos preços de custo dos produtos;
SELECT avg(p.precocusto) AS "Média dos Preços de Custo"  FROM produto p;
--5. Conte quantas mesas estão disponíveis;
SELECT count(m.id) AS "Total de Mesas Disponíveis" FROM mesa m INNER JOIN statusmesa s ON s.id = m.statusmesaid WHERE s.nome = 'Livre'; 
--6. Calcule o valor total de vendas das comanda com status “Paga”;
SELECT SUM(c.valor) AS "Valor total das comandas" FROM comanda c WHERE c.statuscomandaid = 3;
--7. Obtenha o preço de venda máximo dos produtos;
--8. Encontre o o maior valor de uma determinada comanda;
--9. Calcule a média de valor total das comanda;
--10. Conte quantos produtos ativos existem;
SELECT count(p.id) AS "Quantidade de Produtos Ativos" FROM produto p WHERE p.ativo IS TRUE;

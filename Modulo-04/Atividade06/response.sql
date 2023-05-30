-- Calcule o valor total das comandas;
SELECT sum(c.valor) AS "Valor Total das Comandas" FROM comanda c;
-- Obtenha o preço de venda máximo dos produtos;
SELECT max(p.precovenda) AS "Maior Preço de Venda" FROM produto p;
-- Encontre o tempo de preparo mínimo dos produtos;
SELECT MIN(p.tempodepreparo) AS "Tempo de Preparo Mínimo" FROM produto p;
-- Calcule a média dos preços de custo dos produtos;
SELECT avg(p.precocusto) AS "Média dos Preços de Custo"  FROM produto p;
-- Conte quantas mesas estão disponíveis;
SELECT count(m.id) AS "Total de Mesas Disponíveis" FROM mesa m INNER JOIN statusmesa s ON s.id = m.statusmesaid WHERE s.nome = 'Livre'; 
-- Calcule o valor total de vendas por comanda;
SELECT c.codigo AS "Comanda", SUM(c.valor) AS "Total" 
FROM comanda c 
INNER JOIN comandaproduto c2 ON c2.comandaid = c.id 
GROUP BY c.codigo 
ORDER BY c.codigo;
-- Obtenha o preço de venda máximo por categoria de produto;

-- Encontre a quantidade máxima de produtos vendidos por comanda;
SELECT c.codigo AS "Comanda", MAX(c2.quantidade) AS "Quantidade Máxima de Produtos"  
FROM comanda c 
INNER JOIN comandaproduto c2 ON c2.comandaid = c.id 
GROUP BY c.codigo 
ORDER BY c.codigo;
-- Calcule a média de valor total por comanda;
SELECT c.codigo AS "Comanda", AVG(c2.valortotal) AS "Média dos Valores por Comanda"  
FROM comanda c 
INNER JOIN comandaproduto c2 ON c2.comandaid = c.id 
GROUP BY c.codigo 
ORDER BY c.codigo;
-- Conte quantos produtos ativos existem;
SELECT count(p.id) AS "Quantidade de Produtos Ativos" FROM produto p WHERE p.ativo IS TRUE;

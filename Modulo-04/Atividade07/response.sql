--### Atividade 7
--Usando a base de dados do projeto Ravin, construa as seguintes queries:
--1. Liste os nomes únicos dos produtos;
SELECT DISTINCT ON (p.nome) nome FROM ravin.produto p;
--2. Agrupe as comandas pelo status de comanda e conte quantas comandas existem em cada status;
SELECT c.statuscomandaid AS "StatusComandaID", count(c.id) AS "Quantidade" FROM ravin.comanda c GROUP BY c.statuscomandaid;
--3. Encontre a quantidade máxima de produtos vendidos em uma única comanda;
SELECT c.comandaid AS "ComandaId", max(c.quantidade) AS "Maior Quantidade de Produtos" FROM ravin.comandaproduto c GROUP BY c.comandaid;
--4. Liste as mesas que possuem mais de 5 pessoas - HAVING;
SELECT * FROM ravin.mesa m GROUP BY m.id HAVING m.quantidademaximapessoas > 5;
--5. Agrupe os produtos pelo preço de venda e liste os produtos com preço de venda maior que 10;
SELECT max(p.precovenda) AS "Produtos > 10" FROM ravin.produto p GROUP BY p.precovenda HAVING max(p.precovenda) > 10;
--6. Encontre a quantidade média de produtos vendidos por comanda e liste apenas as comandas que possuem uma quantidade média superior a 3;
SELECT c.comandaid, avg(c.quantidade) AS "Media de produtos por comanda" FROM ravin.comandaproduto c GROUP BY c.comandaid HAVING avg(c.quantidade) > 2;
--7. Agrupe os produtos pela descrição e liste apenas aqueles que possuem mais de 5 registros;

-- ENUNCIADO INCOMPREENSÍVEL

--8. Liste as mesas com o número máximo de pessoas e ordene-as em ordem decrescente pela quantidade máxima de pessoas;
SELECT m.codigo, max(m.quantidademaximapessoas) FROM ravin.mesa m GROUP BY m.quantidademaximapessoas, m.codigo ORDER BY m.quantidademaximapessoas DESC;
--9. Agrupe as comandas por cliente e liste apenas os clientes que possuem mais de 3 comandas;
SELECT c.clienteid, count(c.id) FROM ravin.comanda c GROUP BY c.clienteid HAVING count(c.id) >= 2; --na base atual nenhum tem mais DO que 2 comandas

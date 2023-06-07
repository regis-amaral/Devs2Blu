-- ### Atividade 8
ALTER DATABASE restaurante SET search_path TO ravin;
-- 1. Qual o produto com o maior preço de custo
SELECT * FROM produto ORDER BY precocusto DESC LIMIT 1;
-- 2. Qual o produto com o maior preço de venda
SELECT * FROM produto ORDER BY precovenda DESC LIMIT 1;
-- 3. Qual produto com o menor preço de custo
SELECT * FROM produto ORDER BY precocusto ASC LIMIT 1;
-- 4. Qual produto com o menor preço de venda
SELECT * FROM produto ORDER BY precovenda ASC LIMIT 1;
-- 5. A comanda mais recente
SELECT * FROM comanda ORDER BY criadoem DESC LIMIT 1;
-- 6. A comanda mais velha
SELECT * FROM comanda ORDER BY criadoem ASC limit 1;
-- 7. A comanda com maior valor (baseado campo valor da tabela “comanda”)
SELECT * FROM comanda ORDER BY valor DESC LIMIT 1;
-- 8. As 3 comandas com maior valor (baseado campo valor da tabela “comanda”) ordenadas em ordem crescente
SELECT * from comanda ORDER BY valor DESC LIMIT 3;
-- 9. Atualizar a tabela de pessoa para adicionar valores nos campos de data de nascimento

CREATE OR REPLACE FUNCTION gerar_data_aleatoria(start_date date, end_date date)
RETURNS date AS $$
BEGIN
    RETURN start_date + (random() * (end_date - start_date + 1))::integer;
END;
$$ LANGUAGE plpgsql;

UPDATE pessoa
SET datanascimento = gerar_data_aleatoria(DATE '1970-01-01', DATE '2010-12-31')
WHERE datanascimento IS NULL;

SELECT * FROM pessoa WHERE datanascimento IS NULL;

-- 10. Os clientes que são aniversariantes do mês
SELECT * FROM pessoa
WHERE EXTRACT(MONTH FROM datanascimento) = EXTRACT(MONTH FROM CURRENT_DATE);
-- 11. O código das mesas que onde não possuem atendentes alocados
SELECT * FROM mesa LEFT JOIN pessoa ON pessoa.id = mesa.atendenteid WHERE pessoa.id IS NULL;
-- ou
SELECT * FROM mesa WHERE atendenteid IS NULL;
-- 12. A quantidade de atendentes que existem cadastrados
SELECT count(DISTINCT mesa.atendenteid) AS "Qtd de Atendentes" FROM mesa JOIN pessoa ON pessoa.id = mesa.atendenteid;
-- 13. A quantidade de comandas dos dois últimos anos (baseados na data e hoje) 
SELECT * FROM comanda WHERE criadoem BETWEEN NOW() - INTERVAL '2 years' AND NOW(); 
-- 14. O maior valor de comanda (baseado campo valor da tabela “comanda”) dia a dia do mês atual
SELECT criadoem, max(valor) as "Maiores valores dia-a-dia no mês atual" FROM comanda 
WHERE EXTRACT(MONTH FROM criadoem) = EXTRACT(MONTH FROM CURRENT_DATE) 
GROUP BY criadoem ORDER BY criadoem ASC;
-- 15. O valor de cada comanda (baseado na soma dos valores dos produtos da comanda) juntamente com valor do item mais caro que compõe a comanda 
SELECT c.codigo as "Comanda", SUM(cp.quantidade * cp.valortotal) as "Valor Total", max(cp.valortotal) as "Maior valor" FROM comandaproduto cp
JOIN comanda c on c.id = cp.comandaid
GROUP BY cp.comandaid, c.codigo;
-- 16. O valor que cada cliente já gastou no restaurante 
SELECT p.nome, sum(c.valor) FROM comanda c JOIN pessoa p ON p.id = c.clienteid GROUP BY c.clienteid, p.nome ORDER BY p.nome;
-- 17. A lista de códigos das mesas juntamente com o nome dos atendentes responsáveis por cada mesa (apenas as mesas que contém atendente)
SELECT m.codigo as "Código da Mesa", p.nome as "Atendente" FROM mesa m JOIN pessoa p ON p.id = m.atendenteid;
-- 18. A lista das comandas com seus produtos mostrando o código da comanda e o nome do produto
SELECT c.codigo, p.nome FROM comanda c JOIN comandaproduto cp on cp.comandaid = c.id JOIN produto p ON p.id = cp.produtoid ORDER BY c.codigo;
-- 19. Os valores totais de cada comanda (baseado na soma dos itens da tabela “comandaProduto”)
SELECT c.codigo as "Comanda", SUM(cp.quantidade * cp.valortotal) as "Valor Total" FROM comandaproduto cp
JOIN comanda c on c.id = cp.comandaid
GROUP BY cp.comandaid, c.codigo;
-- 20. A comanda que teve o maior valor, mostrando o código da comanda, o valor da comanda e o nome do atendente responsável por aquela comanda
SELECT c.codigo, max(c.valor) as "maiorvalor", p.nome FROM comanda c 
JOIN mesa m ON m.id = c.mesaid 
JOIN pessoa p ON p.id = m.atendenteid 
GROUP BY c.codigo, p.nome
ORDER BY maiorvalor DESC
LIMIT 1
-- 21. A quantidade de clientes em cada dia

-- 22. O funcionário mais velho que já fez algum atendimento

-- 23. A comanda com maior valor (baseado na soma dos itens da tabela “comandaProduto”) e que não está paga

-- 24. A comanda com menor valor (baseado na soma dos itens da tabela “comandaProduto”) e que já está paga

-- 25. A quantidade de clientes que tem comandas em aberto

-- 26. O valor arrecadado por cada mesa (baseado campo valor da tabela “comanda”)

-- 27. A quantidade de clientes que nunca consumiram no restaurante

-- 28. Os clientes que nunca consumiram no restaurante

-- 29. As comandas que estão em mesas ocupadas juntamente com seu valor (baseado campo valor da tabela “comanda”)

-- 30. Os 10 produtos mais vendidos (último mês)

-- 31. O valor da comanda com maior valor e com menor valor (baseado campo valor da tabela “comanda”)

-- 32. Os produtos que nunca saíram em nenhuma comanda 

-- 33. A quantidade de vezes que um produto saiu em cada comanda



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
-- 10. Os clientes que são aniversariantes do mês
-- 11. O código das mesas que onde não possuem atendentes alocados
-- 12. A quantidade de atendentes que existem cadastrados
-- 13. A quantidade de comandas dos dois últimos anos (baseados na data e hoje) 
-- 14. O maior valor de comanda (baseado campo valor da tabela “comanda”) dia a dia do mês atual
-- 15. O valor de cada comanda (baseado na soma dos valores dos produtos da comanda) juntamente com valor do item mais caro que compõe a comanda 
-- 16. O valor que cada cliente já gastou no restaurante 
-- 17. A lista de códigos das mesas juntamente com o nome dos atendentes responsáveis por cada mesa (apenas as mesas que contém atendente)
-- 18. A lista das comandas com seus produtos mostrando o código da comanda e o nome do produto
-- 19. Os valores totais de cada comanda (baseado na soma dos itens da tabela “comandaProduto”)
-- 20. A comanda que teve a maior valor, mostrando o código da comanda, o valor da comanda e o nome do atendente responsável por aquela comanda
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

-- 1. Selecione todos os registros da tabela "pessoa";
SELECT * FROM pessoa p;

-- 2. Recupere o nome e o CPF de todas as pessoas ativas na tabela "pessoa";
SELECT nome, cpf FROM pessoa WHERE ativo IS TRUE;

-- 3. Obtenha o nome e o valor de todos os produtos da tabela "produto";
SELECT nome, precovenda FROM produto;

-- 4. Selecione o código e o número de todas as mesas da tabela "mesa";
SELECT codigo, numero FROM mesa;

-- 5. Recupere o nome e a descrição de todos os produtos ativos na tabela "produto";
SELECT nome, descricao FROM produto WHERE ativo IS TRUE;

-- 6. Selecione o nome e o preço de venda de todos os produtos da tabela "produto" com preço de venda não nulo;
SELECT nome, precovenda FROM produto WHERE precovenda IS NOT NULL;

-- 7. Recupere o nome e o telefone de todas as pessoas ativas na tabela "pessoa" que possuem um telefone cadastrado;
SELECT nome, telefone FROM pessoa WHERE ativo IS TRUE AND telefone IS NOT null;

-- 8. Obtenha o nome e o valor total de todos os produtos da tabela "comandaProduto".

-- 9. Listar todas as comandas com valor maior ou igual de 50 reais;

-- 10. Listar os produtos com valor abaixo dos 10 reais;

-- 11. Selecione o nome e o código de todas as mesas da tabela "mesa" que estão associadas a um atendente específico (por exemplo, atendenteId = 1);

-- 12. As comandas que tenham valor entre 30 e 50 reais;

-- 13. Selecione o código das mesas que foram atendidas pela atendete Fernanda Oliveira (por exemplo, atendenteId = 1);

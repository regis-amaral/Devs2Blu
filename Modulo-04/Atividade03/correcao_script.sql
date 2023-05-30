-- adicionar a constraint de UNIQUE KEY no campo nome
ALTER TABLE statusComanda add CONSTRAINT uniqueComandaNome UNIQUE (nome);

-- PESSOA
-- MUDAR TIPO CAMPO CPF PARA CHAR(11)
-- MUDAR TIPO CAMPO TELEFONE PARA INTEGER
-- MUDAR TIPO CAMPO DATANASCIMENTO PARA DATE
-- DROPAR CAMPO TIPO SANGUINEO
-- ADICIONAR CAMPO CNPJ
ALTER TABLE pessoa ALTER cpf SET DATA TYPE char(11);
ALTER TABLE pessoa ALTER telefone SET DATA TYPE integer USING telefone::integer;
ALTER TABLE pessoa ALTER dataNascimento SET DATA TYPE date USING dataNascimento::date;
ALTER TABLE pessoa DROP COLUMN IF EXISTS tipoSanguineo;
ALTER TABLE pessoa ADD COLUMN IF NOT EXISTS cnpj char(14);

-- CRIAR TABELA STATUSMESA
CREATE TABLE IF NOT EXISTS statusMesa(
	id SERIAL PRIMARY KEY,
	nome varchar(255)
);

-- MESA
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO ATENDENTEID
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO STATUSMESAID
-- ALTERAR O TIPO DO CAMPO CODIGO PARA CHAR(5)
-- MUDAR O TIPO DO CAMPO NUMERO PARA SMALLINT
-- MUDAR O TIPO DO CAMPO QUANTIDADEMAXIMADEPESSOAS PARA SMALLINT
-- ADICIONAR A CONSTRAINT DE UNIQUE KEY NO CAMPO NUMERO
-- ADICIONAR A CONSTRAINT FOREIGN KEY PARA ATENDENTEID
-- ADICIONAR A CONSTRAINT FOREIGN KEY PARA STATUSMESAID
ALTER TABLE mesa ALTER atendenteId SET NOT NULL;
ALTER TABLE mesa ALTER statusMesaId SET NOT NULL;
ALTER TABLE mesa ALTER codigo SET DATA TYPE char(5);
ALTER TABLE mesa ALTER numero SET DATA TYPE SMALLINT;
ALTER TABLE mesa ALTER quantidadeMaximaPessoas SET DATA TYPE SMALLINT;
ALTER TABLE mesa ADD CONSTRAINT uniqueNumero UNIQUE (numero);
ALTER TABLE mesa ADD CONSTRAINT fkAtendenteId FOREIGN KEY (atendenteId) REFERENCES pessoa(id);
ALTER TABLE mesa ADD CONSTRAINT fkStatusMesaId FOREIGN KEY (statusMesaId) REFERENCES statusMesa(id);

-- COMANDA
-- ALTERAR MESAID PARA INTEGER
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO MESAID
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO CLIENTEID
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO STATUSCOMANDAID
-- ALTERAR VALOR PARA DOUBLE PRECISION
-- ADICIONAR A CONSTRAINT DE FOREING KEY NO CAMPO MESAID
ALTER TABLE comanda ALTER mesaId SET DATA TYPE integer USING mesaId::integer;
ALTER TABLE comanda ALTER mesaId SET NOT NULL;
ALTER TABLE comanda ALTER clienteId SET NOT NULL;
ALTER TABLE comanda ALTER statusComandaId SET NOT NULL;
ALTER TABLE comanda ALTER valor SET DATA TYPE DOUBLE PRECISION;
ALTER TABLE comanda ADD CONSTRAINT fkMesaId FOREIGN KEY (mesaId) REFERENCES mesa(id);

-- PRODUTO
-- ALTERAR NOME PARA VARCHAR(255)
-- ADICIONAR A CONSTRAINT DE UNIQUE KEY NO CAMPO NOME
ALTER TABLE produto ALTER nome SET DATA TYPE varchar(255);
ALTER TABLE produto ADD CONSTRAINT uniqueProdutoNome UNIQUE (nome);

-- EXCLUIR A TABLE CARDAPIO
DROP TABLE cardapio;

-- COMANDA PRODUTO
-- ALTERAR O TIPO DO CAMPO ALTERADOEM DE BOOLEAN PARA TIMESTAMP
-- ADICIONAR A CONSTRAINT DE NOT NULL NO CAMPO ALTERADOEM 
ALTER TABLE comandaProduto ALTER COLUMN alteradoEm TYPE varchar USING alteradoEm::varchar;
ALTER TABLE comandaProduto ALTER COLUMN alteradoEm TYPE timestamp USING alteradoEm::timestamp;
ALTER TABLE comandaProduto ALTER alteradoEm SET NOT NULL;

-- USUARIO
-- ALTERAR LOGIN PARA VARCHAR(255)
ALTER TABLE usuario ALTER login SET DATA TYPE varchar(255);
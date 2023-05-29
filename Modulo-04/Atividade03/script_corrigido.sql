CREATE TABLE IF NOT EXISTS statusComanda (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    CONSTRAINT uniqueStatusComandaNome UNIQUE (nome)
);
-- adicionar a constraint de UNIQUE KEY no campo nome
ALTER TABLE statusComanda add CONSTRAINT uniqueComandaNome UNIQUE (nome);

CREATE TABLE IF NOT EXISTS statusComandaProduto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipoPessoa CHAR(1) NOT NULL,
    cpf VARCHAR(110),
    telefone TEXT,
    ativo BOOLEAN NOT NULL,
    dataNascimento VARCHAR(8),
    tipoSanguineo CHAR(3),
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL
);

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
-- ADICIONAR CONSTRAINT DE FOREIGN KEY NO CAMPO STATUSMESAID
-- ADICIONAR CONSTRAINT DE FOREING KEY NO CAMPO ATENDENTEID
CREATE TABLE IF NOT EXISTS statusMesa(
	id SERIAL PRIMARY KEY,
	nome varchar(255)
);

CREATE TABLE IF NOT EXISTS mesa (
    id SERIAL PRIMARY KEY,
    atendenteId INTEGER,
    statusMesaId INTEGER,
    nome VARCHAR(255),
    codigo VARCHAR(255),
    numero INTEGER NOT NULL,
    quantidadeMaximaPessoas INTEGER,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL,
    CONSTRAINT uniqueCodigo UNIQUE (codigo)
);
-- MESA
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO ATENDENTEID
-- CRIAR CONSTRAINT NOT NULL PARA O CAMPO STATUSMESAID
-- ALTERAR O TIPO DO CAMPO CODIGO PARA CHAR(5)
-- MUDAR O TIPO DO CAMPO NUMERO PARA SMALLINT
-- MUDAR O TIPO DO CAMPO QUANTIDADEMAXIMADEPESSOAS PARA SMALLINT
-- ADICIONAR A CONSTRAINT DE UNIQUE KEY NO CAMPO NUMERO

ALTER TABLE mesa ALTER atendenteId SET NOT NULL;
ALTER TABLE mesa ALTER statusMesaId SET NOT NULL;
ALTER TABLE mesa ALTER codigo SET DATA TYPE char(5);
ALTER TABLE mesa ALTER numero SET DATA TYPE SMALLINT;
ALTER TABLE mesa ALTER quantidadeMaximaPessoas SET DATA TYPE SMALLINT;
ALTER TABLE mesa ADD CONSTRAINT uniqueNumero UNIQUE (numero);
ALTER TABLE mesa ADD CONSTRAINT fkAtendenteId FOREIGN KEY (atendenteId) REFERENCES statusMesa(id);

CREATE TABLE IF NOT EXISTS comanda (
    id SERIAL PRIMARY KEY,
    mesaId VARCHAR(255),
    clienteId INTEGER,
    statusComandaId INTEGER,
    codigo VARCHAR(255),
    valor FLOAT NOT NULL,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL,
    CONSTRAINT uniqueComandaCodigo UNIQUE (codigo),
    FOREIGN KEY (clienteId) REFERENCES pessoa(id),
    FOREIGN KEY (statusComandaId) REFERENCES statusComanda(id)
);
-- COMANDA
-- ALTERAR MESAID PARA INTEGER
-- ALTERAR VALOR PARA DOUBLE PRECISION
-- ADICIONAR A CONSTRAINT DE FOREING KEY NO CAMPO MESAID
ALTER TABLE comanda ALTER mesaId SET DATA TYPE integer USING mesaId::integer;
ALTER TABLE comanda ALTER valor SET DATA TYPE DOUBLE PRECISION;
ALTER TABLE comanda ADD CONSTRAINT fkMesaId FOREIGN KEY (mesaId) REFERENCES mesa(id);

CREATE TABLE IF NOT EXISTS produto (
    id SERIAL PRIMARY KEY,
    nome INTEGER,
    descricao VARCHAR(255),
    codigo VARCHAR(255) CONSTRAINT uniqueProdutoCodigo UNIQUE,
    precoCusto DOUBLE PRECISION NOT NULL,
    precoVenda DOUBLE PRECISION,
    tempoDePreparo TIME,
    observacoes VARCHAR(255),
    ativo BOOLEAN NOT NULL,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL
);
-- PRODUTO
-- ALTERAR NOME PARA VARCHAR(255)
-- ADICIONAR A CONSTRAINT DE UNIQUE KEY NO CAMPO NOME
ALTER TABLE produto ALTER nome SET DATA TYPE varchar(255);
ALTER TABLE produto ADD CONSTRAINT uniqueProdutoNome UNIQUE (nome);

CREATE TABLE IF NOT EXISTS CARDAPIO (
    id SERIAL PRIMARY KEY,
    pessoaId INTEGER,
    login VARCHAR(1) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL,
    FOREIGN KEY (pessoaId) REFERENCES pessoa(id)
);
-- EXCLUIR A TABLE CARDAPIO
DROP TABLE cardapio;

CREATE TABLE IF NOT EXISTS comandaProduto (
    id SERIAL PRIMARY KEY,
    comandaId INTEGER NOT NULL,
    produtoId INTEGER NOT NULL,
    statusComandaProdutoId INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    valorTotal DOUBLE PRECISION NOT NULL,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm BOOLEAN,
    alteradoPor VARCHAR(255) NOT NULL,
    FOREIGN KEY (comandaId) REFERENCES comanda(id),
    FOREIGN KEY (produtoId) REFERENCES produto(id),
    FOREIGN KEY (statusComandaProdutoId) REFERENCES statusComandaProduto(id)
);
-- COMANDA PRODUTO
-- ALTERAR O TIPO DO CAMPO ALTERADOEM DE BOOLEAN PARA TIMESTAMP
-- ADICIONAR A CONSTRAINT DE NOT NULL NO CAMPO ALTERADOEM 
ALTER TABLE comandaProduto ALTER COLUMN alteradoEm TYPE varchar USING alteradoEm::varchar;
ALTER TABLE comandaProduto ALTER COLUMN alteradoEm TYPE timestamp USING alteradoEm::timestamp;

CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    pessoaId INTEGER,
    login VARCHAR(1) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    criadoEm TIMESTAMP NOT NULL,
    criadoPor VARCHAR(255) NOT NULL,
    alteradoEm TIMESTAMP NOT NULL,
    alteradoPor VARCHAR(255) NOT NULL,
    FOREIGN KEY (pessoaId) REFERENCES pessoa(id)
);
-- USUARIO
-- ALTERAR LOGIN PARA VARCHAR(255)
ALTER TABLE usuario ALTER login SET DATA TYPE varchar(255);

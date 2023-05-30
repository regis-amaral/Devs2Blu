CREATE TABLE IF NOT EXISTS statusComanda (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    CONSTRAINT uniqueStatusComandaNome UNIQUE (nome)
);

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
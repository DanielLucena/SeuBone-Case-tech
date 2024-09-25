CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    preco_cheio DECIMAL(10,2) NULL,
	preco_descontado DECIMAL(10,2) NULL,
    sku VARCHAR(255) NULL
);
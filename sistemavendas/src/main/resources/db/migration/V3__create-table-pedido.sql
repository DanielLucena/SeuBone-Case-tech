CREATE TABLE pedido (
	id SERIAL PRIMARY KEY,
	desconto DECIMAL(10,2) NULL,
	forma_pagamento int2 NULL,
	prazo int2 NULL,
	soma DECIMAL(10,2) NULL,
	status int2 NULL,
	valor_frete DECIMAL(10,2) NULL
);
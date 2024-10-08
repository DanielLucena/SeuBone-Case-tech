CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    produto_id SERIAL NOT NULL,
    pedido_id SERIAL NOT NULL
);

ALTER TABLE item
ADD CONSTRAINT ITEMS_PRODUTO_ID_FK
FOREIGN KEY (produto_id) REFERENCES produto;

ALTER TABLE item
ADD CONSTRAINT ITEMS_PEDIDO_ID_FK
FOREIGN KEY (pedido_id) REFERENCES pedido;


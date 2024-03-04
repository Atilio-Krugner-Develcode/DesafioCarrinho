CREATE TABLE carrinho (
    id int(1) AUTO_INCREMENT,
    cliente_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE carrinho_items (
    id int(1) AUTO_INCREMENT,
    carrinho_id integer,
    produto_id integer,
    quantidade integer,
    PRIMARY KEY (id)
);

ALTER TABLE carrinho_items
ADD FOREIGN KEY (carrinho_id)
REFERENCES carrinho (id);

ALTER TABLE carrinho_items
ADD FOREIGN KEY (produto_id)
REFERENCES produtos (id);


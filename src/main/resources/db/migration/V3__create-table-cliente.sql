CREATE TABLE clientes(
  id int(1) AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  carrinho_id integer,
  PRIMARY KEY (id)

 );

ALTER TABLE clientes
ADD FOREIGN KEY (carrinho_id)
REFERENCES carrinho (id);
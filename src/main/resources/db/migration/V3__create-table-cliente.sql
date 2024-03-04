CREATE TABLE clientes(
  id int(1) AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  PRIMARY KEY (id)
 );

ALTER TABLE carrinho
ADD FOREIGN KEY (cliente_id)
REFERENCES clientes (id);
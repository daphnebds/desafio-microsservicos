CREATE TABLE item_pedido (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    descricao varchar(255) DEFAULT NULL,
    quantidade int NOT NULL,
    id_pedido bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id)
);

CREATE TABLE pagamento (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    codigo varchar(3) DEFAULT NULL,
    expiracao varchar(7) NOT NULL,
    forma_de_pagamento varchar (100) NOT NULL,
    id_pedido bigint NOT NULL,
    nome varchar(255) DEFAULT NULL,
    numero varchar(255) DEFAULT NULL,
    status varchar(255) NOT NULL,
    valor decimal(19,2) NOT NULL,
    PRIMARY KEY (id)
);

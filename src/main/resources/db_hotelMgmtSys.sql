CREATE TABLE hotel (
    id serial PRIMARY KEY,
    nome varchar(100) NOT NULL,
    descricao varchar(100) NOT NULL,
    preco decimal NOT NULL,
    reservaCliente varchar(100),
    reservaDataInicio varchar(100),
    reservaDataFim varchar(100)
);

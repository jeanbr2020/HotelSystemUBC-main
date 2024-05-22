CREATE TABLE hotel (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    preco DECIMAL(19, 2) NOT NULL,
    reservaCliente VARCHAR(255),
    reservaDataInicio VARCHAR(255),
    reservaDataFim VARCHAR(255)
);

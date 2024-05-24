-- Criação da tabela Hospedes
CREATE TABLE Hospedes (
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    Idade INT,
    Contato VARCHAR(100)
);

-- Criação da tabela Funcionarios
CREATE TABLE Funcionarios (
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    Cargo VARCHAR(100)
);

-- Criação da tabela Tipos_de_quarto
CREATE TABLE Tipos_de_quarto (
    ID SERIAL PRIMARY KEY,
    Tipo VARCHAR(50)
);

-- Criação da tabela Reserva
CREATE TABLE Reserva (
    ID SERIAL PRIMARY KEY,
    ID_Hospede INT REFERENCES Hospedes(ID),
    Data DATE,
    ID_Tipo_de_quarto INT REFERENCES Tipos_de_quarto(ID)
);

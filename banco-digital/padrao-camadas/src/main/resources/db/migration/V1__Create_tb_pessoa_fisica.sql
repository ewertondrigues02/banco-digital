CREATE TABLE tb_pessoa_fisica (
                                  pessoa_fisica_id SERIAL PRIMARY KEY,
                                  nome VARCHAR(255) NOT NULL,
                                  cpf VARCHAR(14) NOT NULL UNIQUE,
                                  email VARCHAR(255) NOT NULL UNIQUE,
                                  saldo NUMERIC(15, 2),
                                  senha VARCHAR(20) NOT NULL,
                                  CONSTRAINT chk_cpf_format CHECK (cpf LIKE '___.___.___-__'),
    CONSTRAINT chk_senha_length CHECK (LENGTH(senha) BETWEEN 8 AND 20)
);
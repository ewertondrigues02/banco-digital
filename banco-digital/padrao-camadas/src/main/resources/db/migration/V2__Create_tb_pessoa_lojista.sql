CREATE TABLE tb_pessoa_lojista (
                                   pessoa_lojista_id SERIAL PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
                                   cnpj VARCHAR(18) NOT NULL UNIQUE,
                                   email VARCHAR(255) NOT NULL UNIQUE,
                                   saldo NUMERIC(15, 2),
                                   senha VARCHAR(20) NOT NULL,
                                   CONSTRAINT chk_cnpj_format CHECK (cnpj ~ '^[0-9]{2}\\.([0-9]{3}){2}\\/([0-9]{4}){2}\\-[0-9]{2}$'),
    CONSTRAINT chk_senha_length_logista CHECK (LENGTH(senha) BETWEEN 8 AND 20)
);
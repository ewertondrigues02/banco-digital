
# Banco Digital - Nos 4 Padrões de Projeto mais Utilizados


Este repositório contém uma aplicação de um banco digital desenvolvida com **Spring Boot 3.4.1** e **Java 21**, explorando diferentes **padrões de projeto**:  
- **Padrão em Camadas**   -   Em Desenvolvimento
- **Factory Method**   -   Na Fila de Desenvolvimento
- **Singleton**   -   Na Fila de Desenvolvimento
- **MVC**   -   Na Fila de Desenvolvimento

O objetivo é demonstrar as diferenças e benefícios de cada abordagem, mantendo uma base tecnológica robusta e moderna.

---

## 🛠 Tecnologias Utilizadas  

### 🔹 Backend  

- **Java 21** – Linguagem principal do projeto, utilizada para desenvolver a aplicação com alto desempenho e segurança.  
- **Spring Boot 3.4.1** – Framework para facilitar a configuração e desenvolvimento de aplicações Java baseadas em Spring.  
- **Spring Data JPA** – Abstração para facilitar a persistência de dados utilizando o Hibernate e o banco de dados relacional.  
- **Spring Web** – Permite a criação de APIs REST e configuração de controllers HTTP na aplicação.  
- **Spring Security** – Módulo para gerenciamento de autenticação e autorização, garantindo a segurança da aplicação.  
- **JWT (JSON Web Token)** – Utilizado para autenticação segura e controle de acesso à API.  
- **Spring Boot Mail** – Módulo para envio de e-mails transacionais dentro da aplicação.  
- **Spring Validation** – Utilizado para validar os dados de entrada da aplicação de forma eficiente.  

### 🔹 Banco de Dados  

- **PostgreSQL** – Banco de dados relacional utilizado para armazenar os dados da aplicação.  
- **Amazon RDS** – Serviço de banco de dados gerenciado na nuvem para escalabilidade e alta disponibilidade.  
- **H2 Database** – Banco de dados em memória utilizado para testes e desenvolvimento.  
- **Flyway** – Ferramenta de versionamento e migração do banco de dados, garantindo controle sobre as alterações estruturais.  

### 🔹 Testes  

- **JUnit e Mockito** – Ferramentas para criação e execução de testes unitários e mock de dependências.  
- **Bacon H2** – Biblioteca auxiliar para simplificação e otimização de testes com banco de dados H2.  

### 🔹 Documentação e Monitoramento  

- **Swagger** – Ferramenta para documentação interativa de APIs, permitindo testes e visualização dos endpoints.  
- **Spring Boot Actuator** – Fornece métricas, monitoramento e endpoints para gerenciar a aplicação em tempo real.  
- **Prometheus** – Sistema de monitoramento e coleta de métricas para análise do desempenho da aplicação.  
- **Grafana** – Plataforma para visualização de métricas e dashboards baseados em dados coletados pelo Prometheus.  

### 🔹 Infraestrutura  

- **Docker** – Plataforma de conteinerização que permite empacotar e executar a aplicação de forma isolada.  


---

## 📦 Pré-requisitos

1. **Java 21**  
   - Verifique a instalação:  
     ```bash
     java -version
     ```

2. **Maven 3.8+**  
   - Verifique a instalação:  
     ```bash
     mvn -version
     ```

3. **Docker**  
   - Verifique a instalação:  
     ```bash
     docker --version
     ```

4. **PostgreSQL (opcional)**  
   - Caso não utilize Docker, configure o banco de dados manualmente.

---

## 🚀 Como Usar

### 1. Clone o Repositório

```bash
git clone https://github.com/ewertondrigues02/banco-digital-padroes.git
cd banco-digital-padroes
```

---

### 2. Configuração do Banco de Dados

#### Usando Docker
Execute o seguinte comando para iniciar o container do PostgreSQL:  
```bash
docker-compose up -d
```

#### Configuração Manual (sem Docker)
1. Instale e configure o PostgreSQL.  
2. Crie um banco de dados chamado `banco_digital`.  
3. Edite as configurações em `application.properties` para incluir suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/banco_digital
spring.datasource.username=user
spring.datasource.password=user
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### 3. Inicialize a Aplicação

#### Perfil H2 (memória)
Para usar o banco H2 para testes rápidos, inicie a aplicação com o perfil `h2`:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

#### Perfil PostgreSQL
Para usar o PostgreSQL, inicie a aplicação normalmente:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em:  
[http://localhost:8090](http://localhost:8090)  - Coloque a porta que desejar.

---

## Arquivo Flyway

#### **Tabela Pessoa Física**
```
CREATE TABLE tb_pessoa_fisica (
   pessoa_fisica_id SERIAL PRIMARY KEY,
   nome VARCHAR(255) NOT NULL,
   cpf VARCHAR(14) NOT NULL UNIQUE,
   email VARCHAR(255) NOT NULL UNIQUE,
   saldo NUMERIC(15, 2),
   senha VARCHAR(20) NOT NULL,
   CONSTRAINT chk_cpf_format CHECK (cpf ~ '^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$'),
   CONSTRAINT chk_senha_length CHECK (LENGTH(senha) BETWEEN 8 AND 20)
);

```

---

#### **Tabela Pessoa Lojista**
```
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
```

## 📂 Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com.example.bancodigital/
│   │       ├── config/         # Configurações do Spring (Security, Flyway, etc.)
│   │       ├── controllers/    # Controladores (API REST)
│   │       ├── services/       # Serviços (lógica de negócio)
│   │       ├── repositories/   # Repositórios (JPA)
│   │       ├── models/         # Modelos de domínio
│   │       ├── dto/            # Data Transfer Objects
│   ├── resources/
│       ├── application.properties
│       ├── db/migration/       # Scripts do Flyway
├── test/                       # Testes com JUnit e Mockito
docker-compose.yml              # Configuração do Docker
pom.xml                         # Arquivo Maven
```

---

## 📝 Configurações (`application.properties`)

### Configuração Básica
```properties
spring.application.name=padrao-camadas

# H2 Database
spring.datasource.url=jdbc:h2:mem:banco_digital
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=user
spring.datasource.password=user
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

### Flyway
```properties
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

### E-mail
```properties
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=465
spring.mail.username=2a6aff94c403f1
spring.mail.password=48494d7c3f090c
spring.mail.properties.mail.smtp.ssl.enable=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Segurança
```properties
#spring.security.enabled=false
```

---

## 🛡️ Testes

Execute os testes automatizados com:  
```bash
mvn test
```

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## Diagrama da UML


[Padrão Camadas.pdf](https://github.com/user-attachments/files/18503102/Diagrama.do.Banco.Digital.-.3Core.drawio.pdf) 


 



# Banco Digital - Nos 4 Padrões de Projeto mais Utilizados


Este repositório contém uma aplicação de um banco digital desenvolvida com **Spring Boot 3.4.1** e **Java 21**, explorando diferentes **padrões de projeto**:  
- **Padrão em Camadas**   -   Em Desenvolvimento - Diagrama Conceitual [![Bank](https://img.shields.io/badge/Bank-90EE90?style=flat&logo=fa-university&logoColor=black&logoWidth=100)](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=padrao-camadas-arquitetura.drawio#R7V1tc6M2EP41%2FngeJPH6MXGSXmdybdp0pu2njGJkmx5GHsB2fL%2B%2BAgsbJAjEBuT48M14gkBGsI92n13t6kZosnz7JcSrxTfqEn8ENfdthO5GEALdYN9Jw27f8AVCfd8yDz1336YdG569H4T3zFrXnksi3rZviin1Y29VbJzSICDTuNCGw5Bui5fNqO8WGlZ4TgrDSBqep9gn0mV%2Fe2682LdCQ8td%2FpV480UsnnnF0%2B%2FzkK4DfsMRRFr62Z9e4uzHeEO0wC7d5prQ%2FQhNQkrj%2FV%2FLtwnxk5dbfG8PFWcPAw9JEDfp8M%2FXX7X48a%2Bvv0e%2F6VP9j9XmxzT4olt8cPEueyPEZS%2BIH9IwXtA5DbB%2Ff2y9TR%2BaJD8L2NHxmkdKV7zxPxLHOy5tvI4pa1rES5%2Bfnfl0exN47BV5NOBtURzS7wcZsLdzO12Hm%2FQu2uH0hPo0TIeJHtIPO7N%2FgGTUlS%2BGN0V0HU7JO28DcgDicE7id64D8CA%2FNjEIXZI43LGOIfHZI22KA8EcofPDdbzrTRjiXe6CFfWCOMr98lPSwC7IJhvIsMUnG0BGQeTsj%2F1vZke5wR2bUlh8ACL8pWywvyYZ0gXIpCMn4f2GJA%2FA5ZnBPZGei6PFQZQ5IEhS1bSHBy25aOb5flk7jlZ7NTDz3pJfvPXxK%2FGfaORxLE1JMhR2YkPC2GMT%2FVG44JXGMV3mLrjxvXlyIk7Qe4v50eF36Dr2vYANMlNA2v7pVsnDL9%2FmiV4cbzbuOIppmGobAcvoANLkjuTtfZjKqMo6aJYgfmijscUV8PaovJA15o2LnOLiUCmFYw5AJ%2BBjUCG5t4EaqhBbiQZBmlWEkKYLRuOjPbrRORZQgSkm7HD3T4KWZFrx43%2FzJ%2B%2FeOJb2R7sCsk4AXhmKFYDRVGPOHFSAlsOl3imyUL%2FWLLFbZdaMt1%2BwNVuFNGZXsLu8JCx39cIY%2BMybS2hPHpz1cj12hzsv3Hdh7UkT9pNnp0Gce%2FZZ%2BmnJJELBJDqmJpnDzPAVjCEYG3pH9lDvE2GTSepxSAg7tF8wwiLCtKQX7zojTMgxx5ohUGadKXerjDM5Mkx0ZwxRRzAxLoFWHwzRBcOEKSCXLHHgvkTEn7GvcOMlVq8dTu0InBrAZhpEhxnJbp9QGwOhFrhJAw6D1HAYu6hfHLsHdmzWq45sIuFpnAjndrvwYvK8wumr3rK5VaYw8vr3A545tzRtTEcg2HPblmcjKrPnnTm39jAXBae1SXxMzWREYnwMGLXe7fs9upm%2Fuj6A6uOgOhdTZ%2BkBu17llhKaKuenyiEsUbvg7nbSIu%2FKI4INjsMFwOyYP1AZG8PbSB%2Fj1cpnt0kdQ9eLppTdd5exshd2Sa4Vz1M0CDDTy%2FjmioQeExUJEyPlBfPjEI50tw0LA01hxh%2BiqjkTY%2FVpYpCSWNelagPQdA3m3CWYs2SWjXJYFFHu5APzgp18XYbFzzy3L3txBEqxgDr6WNejG%2FoIGsSwuyIj%2FExBdSlgJjJ9KFe2Mn2Z45hs8e7Fp9h9ecU%2BDqbpzbtRTmJ8GoASh7Y0QN2ZQ2sOGik3lYyenI%2FTNJIOFESXQIPIdPvhpaqFjFbDS7p2YeGl7GbDbEyR1zTWqyr%2FSjT3iM%2BVSoJQ16Oj%2BNLgUZ6EKjVKHooxSCGRsxuMGAMPOAUjxpkQOS%2Fq0GDhp5aM56VREU6ofuXlTL6MfEvsXmTj0yRK%2BBLhGRnHZLoI2N3muxdvSoNonHzDcuJQESdsgx0AE42FQALUZYKgoz4JAhqmaW4CWA2nqX4RdJ1Z%2B5oAQl2PjvjBwDpPAZUifqADJfxgyOo%2BBSOGWoJgdUoQDj56tfeuniC0wQSQIzMBVFpr0S8ZGDh7HuxNEwfUkAFDSbEWaJCoMGQf91GtpYuhH1gWbOy3VAs4ndqHCgfSJTO89uN%2BrQPQJcmCdiTriILVGqYMI7uzlGFLCaM%2F1kuNcsVS%2BeKpT1YvlQnyUgumhDwHh2v76vCz%2Fm6HjuqFNRVKhp2Bd5bZOwkddVvgJNYnOCUBKWiPncLH7NGkWLJw%2B9Q84GzNU61sCjqpa80DG2oecK6DeWIQwvmg6tENFaoHdqp6KvzfgAakf63TCke1L1y7wAapTlcT0OiOsgJDynpWz1mho5azjg2EitZDc2CN%2BUiPnrIlqHdMw0UESJqmW4Jz6ex5US0l1TDVOKjb7OFTYUBvCoFzU27Pg4CSitccBEwrj4AvTBVo6Jpg0FwVWEpxoNokWGwEeVUw1uBV4aCxOjgXBid6GVBcDkd1C%2Bg1PTpaQFdSFZzDKdLNInWxj8C9Bpw2rgI7m7qcGImz7A8Cta5HR6v4aqMzjFsVYFoD0UtFo9E0LNxOcKZEy4l565bgcO9HxrsJRrgNGDVww3%2FilejG%2BFCjrA4lDVmUR6sraxM62GadchN2QRE6dKTbGqwzNCmDY%2F8ektsedjET4npCzMg0OYBKg4CftzDuFQffW4o2QVOAQ0mJvVkSbDK7CiMavW629ZmzIjrdbEs3nCIHuoDNtgzVVN7QdcHlRPY1UfmmFZb73BRVkQdDdeTBKHp0DAbGVQWjm8IgtzV%2Bv6kVZlE1ZQvv1ZynpkdHW7%2Bp3hgZGGKEzDSvCqeNgQpV6itTSV1QDgeS0bqq%2BFNzFCjdlcxUkhCeQwEsxnfGV2WysmzZC3XrNaF2zO7F%2FqjmSZaIuLqMr1LIXWwCauN1OjVpYIaNBMzB7jFnydHHJ%2ByGowka3SDKTkzwEjPvXEImc1VjSZo8UCO5yCU7Y2uCpy8620vPdVOAl21%2FUgT93MdRVAk%2BISJ12PMkH90Roz8GP37AS89PxPEXQzh7B9pvZMu%2B%2F6TMi2%2FHb3fE6LPGBZLz2gEqKYTK6pXaTzqV99i%2F37JHZFMyeXI39OZr0iIe%2BDXnQ0EThGg2E2Iy8OcsFgVkwAjW78xcMWiJxW%2FIkeM0IKsQLUi8szRjeeuDpzE7fvAiJoZPIGlUNs1blBoQ8m1tKE%2FSsphrdxKTa1FTiT3S%2F7woHkTGZpW4aqJcZHLx4PO350FSh%2F%2FzSkxmVycpuZBvkNQorVOwL0tStrxKef9liT1%2FEJaDTIFoOI5qaYFBWlVTy9SQICzF5sqGkrBu1jENvR849Q2tg4f408sOihuJKped7NP%2Fst%2BZd5AWQLBIN4CW7danTFyyw%2F1IsctabrMtlAexQSCkeAJDtTmT816ek4yOvXpMQmcuYV%2F3wcYbtCSTF3DGQp3r8f%2Fczskwmw39yFCOfAwybO5UH9fplQlQDoTc4ul3EriDuNiME3Rm2Y6b%2FYpLDoIM4qpkJurFJUdCbhkhOejFO%2BzSz7AS0LWv7Yi%2BNoCmrlZ0jhwaGURXtiCTJSJcjuTkMMkzma9DHOxZyRDdL9nWHZXvINmv4OSQySA40cYBs0%2FBscOQ0jifMpFk43%2BjLkmu%2BB8%3D)
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
- **Apache JMeter** - Ferramenta para testes de carga e desempenho de aplicações.
- **OWASP ZAP** – Ferramenta de segurança para testes de vulnerabilidades em aplicações web.  

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


 

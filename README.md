
# Banco Digital - Comparação de Padrões de Projeto

Este repositório contém uma aplicação de um banco digital desenvolvida com **Spring Boot 3.4.1** e **Java 21**, explorando diferentes **padrões de projeto**:  
- **Padrão em Camadas**  
- **Factory Method**  
- **Singleton**  
- **MVC**  

O objetivo é demonstrar as diferenças e benefícios de cada abordagem, mantendo uma base tecnológica robusta e moderna.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: 21  
- **Spring Boot**: 3.4.1  
- **Spring Data JPA**  
- **Docker**  
- **PostgreSQL** e **H2 Database**  
- **Spring Security**  
- **Flyway**  
- **Spring Boot Actuator**  
- **Spring Boot Mail**  
- **Spring Validation**  
- **Spring Web**  
- **JUnit** e **Mockito**

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
git clone https://github.com/seu-usuario/banco-digital-padroes.git
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
[http://localhost:8090](http://localhost:8090)

---

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
│   │       ├── factories/      # Implementações de Factory Method
│   │       ├── patterns/       # Implementações dos padrões de projeto
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

## 📧 Contato

Para dúvidas ou sugestões, entre em contato pelo e-mail: **seuemail@dominio.com**.
```
 

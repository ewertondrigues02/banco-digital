# Padrão Camadas

Este é um projeto Java baseado no **Spring Boot** que segue o padrão de camadas, utilizando diversas tecnologias para desenvolvimento de aplicações robustas e escaláveis.

## 📌 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Cloud 2024.0.0**
- **Spring Data JPA**
- **Spring WebFlux**
- **Flyway para migração de banco de dados**
- **PostgreSQL e H2 Database**
- **Spring Cloud Gateway**
- **Log4j e SLF4J para logging**
- **JUnit 5 e Mockito para testes**

## 🚀 Como Executar o Projeto

### 📌 Pré-requisitos
Antes de iniciar, certifique-se de ter instalado:
- **Java 21**
- **Maven 3.8+**
- **Docker (opcional, para rodar o banco PostgreSQL)**

### 📌 Passos para Execução
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/padrao-camadas.git
   cd padrao-camadas
   ```
2. Compile o projeto:
   ```sh
   mvn clean install
   ```
3. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```
4. A aplicação estará disponível em:
   ```
   http://localhost:8081
   ```

## 🛠️ Dependências Principais

| Dependência | Versão |
|-------------|--------|
| **Spring Boot Starter Actuator** | 3.4.1 |
| **Spring Boot Starter Data JPA** | 3.4.1 |
| **Spring Boot Starter Mail** | 3.4.1 |
| **Spring Cloud Starter Gateway** | 2024.0.0 |
| **Spring Cloud LoadBalancer** | 2024.0.0 |
| **Spring Boot Starter Validation** | 3.4.1 |
| **Spring Boot Starter WebFlux** | 3.4.1 |
| **Flyway Core** | 9.22.3 |
| **Flyway PostgreSQL** | 9.22.3 |
| **H2 Database** | 2.1.214 |
| **PostgreSQL Driver** | 42.6.0 |
| **Log4j Core** | 2.20.0 |
| **SLF4J API** | 2.0.9 |
| **Logback Classic** | 1.4.12 |
| **JUnit 5** | 5.9.3 |
| **Mockito Core** | 5.2.0 |

## 🧪 Configurações do `application.properties`

Caso não tenha as configurações abaixo no `application.properties`, adicione:

```properties
# Porta do Servidor
server.port=8081
spring.application.name=padrao-camadas
debug=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql=TRACE
spring.devtools.restart.enabled=false

## Pool de conexões
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=60000
spring.datasource.hikari.max-lifetime=1800000

## Flyway
spring.flyway.url=jdbc:postgresql://postgres_teste
spring.flyway.user=ewerton
spring.flyway.password=123456
spring.flyway.enabled=false
spring.flyway.locations=classpath:db/migration

# Configuração do PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres_teste
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=ewerton
spring.datasource.password=123456

# Configuração do HikariCP (pool de conexões)
spring.datasource.hikari.auto-commit=true
spring.datasource.hikari.transaction-isolation=TRANSACTION_READ_COMMITTED
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.maximum-pool-size=10

# Configuração do Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# E-mail
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=465
spring.mail.username=2a6aff94c403f1
spring.mail.password=48494d7c3f090c
spring.mail.properties.mail.smtp.ssl.enable=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=sandbox.smtp.mailtrap.io

# Twilio
twilio.account.sid=SEU_ACCOUNT_SID
twilio.auth.token=SEU_AUTH_TOKEN
twilio.phone.number=+1234567890

# Swagger
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html

# Logs
logging.level.org.springframework=INFO
logging.level.com.seu.projeto=DEBUG

# Actuator
management.endpoints.web.exposure.include=*

# Configuração do Spring Cloud Gateway
spring.cloud.gateway.routes[0].id=serviceA_route
spring.cloud.gateway.routes[0].uri=lb://SERVICE-A
spring.cloud.gateway.routes[0].predicates[0]=Path=/service-a/**
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true

spring.cloud.gateway.routes[1].id=serviceB_route
spring.cloud.gateway.routes[1].uri=lb://SERVICE-B
spring.cloud.gateway.routes[1].predicates[0]=Path=/service-b/**

# Ativando o Spring Cloud LoadBalancer
spring.cloud.loadbalancer.enabled=true
```

## 🧪 Testes
Os testes unitários são implementados utilizando **JUnit 5** e **Mockito**. Para rodar os testes, utilize:
```sh
mvn test
```

## 🌟 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

👉 Desenvolvido por **Ewerton Rodrigues**


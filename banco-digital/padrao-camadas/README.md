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
   http://localhost:8080
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

## 🧪 Testes
Os testes unitários são implementados utilizando **JUnit 5** e **Mockito**. Para rodar os testes, utilize:
```sh
mvn test
```

## 📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

🔹 Desenvolvido por **Ewerton Rodrigues**



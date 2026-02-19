# FlowStock

FlowStock — sistema de gestão de produtos e estoque desenvolvido com **Java 17** e **Spring Boot 3**. Projeto para aplicar boas práticas de arquitetura, validação e integração com PostgreSQL.

---

## 🚀 Tecnologias
- Java 17  
- Spring Boot 3 (Web, Data JPA, Validation)  
- PostgreSQL  
- Lombok  
- Maven  
- Docker (opcional)

---

## 📁 Estrutura (resumida)
src/
main/
java/
com.techflow.flowstock/ ← domain, dto, repository, service, controller
resources/
application.yml


---

## ⚙️ Requisitos
- Java 17+
- PostgreSQL
- Maven

---

## 🧭 Como rodar

### 1. Build:
```bash
mvn clean package
java -jar target/flowstock-0.0.1-SNAPSHOT.jar

3. Exemplo application.yml:
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/flowstock
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
server:
  port: 8080
------------------

curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
  "name": "Teclado Mecânico Redragon",
  "description": "Switch blue, RGB, ABNT2",
  "sku": "RED-TK-01",
  "price": 289.90,
  "quantity": 12
}'



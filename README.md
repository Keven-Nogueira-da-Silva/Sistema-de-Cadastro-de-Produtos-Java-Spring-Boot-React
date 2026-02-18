🛒 Product Manager API + React

Sistema Full Stack para gerenciamento de produtos desenvolvido com Java (Spring Boot) no back-end e React no front-end.

O projeto foi criado com o objetivo de praticar arquitetura em camadas, construção de APIs REST e integração completa entre front-end e back-end.

🚀 Tecnologias Utilizadas
🔹 Back-end

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Hibernate

Bean Validation

PostgreSQL

Maven

🔹 Front-end

React

JavaScript (ES6+)

Hooks (useState, useEffect)

Fetch API

CSS

🏗️ Arquitetura

O back-end foi estruturado seguindo boas práticas:

Controller → Camada de entrada da API

Service → Regras de negócio

Repository → Acesso ao banco de dados

DTO → Transferência de dados

Mapper → Conversão Entity ↔ DTO

Tratamento global de exceções

📌 Funcionalidades

✔ Cadastro de produtos
✔ Listagem de produtos
✔ Atualização de produtos
✔ Remoção de produtos
✔ Validação de campos obrigatórios
✔ Integração com banco PostgreSQL
✔ Comunicação completa Front-end ↔ Back-end

🔄 Endpoints da API

POST /products
GET /products
GET /products/{id}
PUT /products
DELETE /products/{id}

▶️ Como Executar o Projeto
🔹 Back-end

Configurar o PostgreSQL

Atualizar o application.properties

Rodar:

mvn spring-boot:run


API disponível em:

http://localhost:8080

🔹 Front-end

Entrar na pasta do projeto React

Instalar dependências:

npm install


Executar:

npm start


Aplicação disponível em:

http://localhost:3000

🎯 Objetivo do Projeto

Este projeto foi desenvolvido para consolidar conhecimentos em:

Desenvolvimento de APIs REST

Integração front-end e back-end

Organização de código em camadas

Boas práticas no ecossistema Spring

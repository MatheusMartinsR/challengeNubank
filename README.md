# Desafio Nubank - API REST com Java + Spring Boot + PostgreSQL

## 📋 Descrição
API REST desenvolvida para estudo, com o objetivo de gerenciar **clientes** e seus respectivos **contatos**.

---

## ✅ Funcionalidades

- [x] **Cadastro de cliente**  
  `POST /clients`

- [x] **Cadastro de contato vinculado a cliente**  
  `POST /clients/{clientId}/contacts`

- [x] **Listagem de todos os clientes**  
  `GET /clients`

- [x] **Listagem de um cliente específico (com seus contatos, se houver)**  
  `GET /clients/{id}`

- [x] **Documentação interativa com Swagger**  
  Acesse em: `/swagger-ui/index.html`

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- Swagger / Springdoc OpenAPI
- Maven

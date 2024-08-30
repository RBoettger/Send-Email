
# Projeto de Estudo: Microservices com Spring Boot

Este repositório contém um projeto de estudo no qual foram desenvolvidas duas APIs seguindo a arquitetura de microservices. O objetivo do projeto é praticar a criação de microservices usando Spring Boot, comunicação entre serviços via RabbitMQ, e persistência de dados com PostgreSQL.

## APIs Desenvolvidas

### 1. **User API**
- **Descrição:** A User API é responsável pelo cadastro de usuários no banco de dados. Ela recebe as informações de nome de usuário e email, validando e armazenando esses dados no PostgreSQL.
- **Tecnologias Utilizadas:** Spring Boot, PostgreSQL.

### 2. **Email API**
- **Descrição:** A Email API é responsável pela configuração e envio de emails. Ela recebe mensagens da fila do RabbitMQ, processa as informações e envia o email.
- **Tecnologias Utilizadas:** Spring Boot, RabbitMQ.

## Arquitetura do Projeto

O projeto é composto por dois microservices independentes:

- **User Service:** Gerencia o cadastro de usuários e envia uma mensagem para o RabbitMQ assim que um novo usuário é cadastrado.
- **Email Service:** Consome mensagens do RabbitMQ e realiza o envio de emails baseados nas informações recebidas.

### Tecnologias e Ferramentas
- **Spring Boot:** Framework para o desenvolvimento dos microservices.
- **RabbitMQ:** Sistema de mensageria usado para a comunicação assíncrona entre os serviços.
- **PostgreSQL:** Banco de dados relacional utilizado para armazenar as informações dos usuários.
- **Insomnia:** Ferramenta usada para testar as APIs.

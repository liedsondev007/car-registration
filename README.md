# Car API

Este projeto é uma API RESTful para gerenciar informações de carros. A API permite criar e consultar registros de carros em um banco de dados MySQL. A aplicação foi desenvolvida utilizando Java 17, Spring Boot, JPA e JDBC.

## Requisitos

- Java 17
- Maven
- MySQL

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL chamado `db_car`.
2. Configure o usuário e senha do MySQL para `root` no arquivo `application.properties` ou `application.yaml`.

## Instalação

1. Clone o repositório:
   ```sh
   git clone https://github.com/liedsondev007/car-api.git
   cd car-api

## Endpoints
## POST /cars
Cria um novo registro de carro.

- URL: `/cars`
- Método HTTP: `POST`
- Corpo da Requisição:
  ```
  {
  "model": "New Fiesta",
  "brand": "Ford",
  "color": "Azul",
  "fabricationYear": "2014/2015"
  }
  
- Resposta de Sucesso:
 - Status: `201 Created`
- Regras de Validação:
1. O campo brand deve ser uma das seguintes marcas: Ford, Chevrolet, BMW, Volvo. Caso contrário, retornará 404 Not Found.
2. Todos os campos são obrigatórios.

## GET /cars/{chassiId}
Retorna os detalhes de um carro específico.

- URL: `/cars/{chassiId}`
- Método HTTP: `GET`
- Resposta de Sucesso:
 - Status: `200 OK`
- Corpo da Resposta:
  ```
  {
  "chassiId": 123,
  "model": "New Fiesta",
  "brand": "Ford",
  "color": "Azul",
  "fabricationYear": "2014/2015"
  }
- Resposta de Erro:
- Status: `404 Not Found se o carro não for encontrado.`

## Estrutura do Projeto
- Entidade: Representa o modelo de dados do carro.
- DTOs: Objetos de Transferência de Dados utilizados para receber e enviar dados através da API.
- Repositório: Interface para interagir com o banco de dados.
- Serviço: Contém a lógica de negócio para salvar e buscar carros do banco de dados.
Controlador: Define os endpoints da API.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests e/ou enviar um feedback pro meu código.
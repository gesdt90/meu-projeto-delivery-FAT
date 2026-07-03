# Delivery API

API REST desenvolvida com Spring Boot para gerenciamento de restaurantes, produtos, clientes e pedidos.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger

## Como executar

Clone o projeto:

```bash
git clone https://github.com/SEU_USUARIO/delivery-api-seunome.git
```

Entre na pasta:

```bash
cd delivery-api-seunome
```

Execute:

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

## Banco H2

```
http://localhost:8080/h2-console
```

JDBC URL

```
jdbc:h2:mem:deliverydb
```

Usuário

```
sa
```

Senha

```
(em branco)
```

## Endpoints

### Restaurantes

GET

```
GET /restaurantes
```

POST

```
POST /restaurantes
```

PUT

```
PUT /restaurantes/{id}
```

DELETE

```
DELETE /restaurantes/{id}
```

Os demais recursos seguem o mesmo padrão:

- Clientes
- Produtos
- Pedidos

## Autor

Gessica Dutra
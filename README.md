# 🎬 API REST de Cadastro de Filmes (CRUD Completo)

Este projeto implementa uma API RESTful completa para o cadastro e manutenção de registros de Filmes, seguindo os princípios de um CRUD (Create, Read, Update, Delete). A aplicação é construída utilizando o framework Spring Boot, garantindo uma arquitetura robusta e escalável.

---

## 💻 Tecnologias Utilizadas

| Tecnologia | Descrição |
| :--- | :--- |
| **Framework** | Spring Boot 3.x |
| **Linguagem** | Java (versão definida no pom.xml) |
| **Persistência** | Spring Data JPA / Hibernate |
| **Banco de Dados** | H2 Database (em memória, para desenvolvimento) |
| **Utilitário** | Lombok (para reduzir código, Construtor e Getters e Setters) |
| **Build Tool** | Maven (ou Gradle, dependendo da sua escolha) |

---

## 🛠️ Arquitetura e Estrutura

O projeto segue a arquitetura de camadas amplamente utilizada em aplicações Spring:

* **`model`:** Contém a Entidade `Filme` (mapeada para o banco de dados).
* **`repository`:** Interface `FilmeRepository` para acesso aos dados (via JpaRepository).
* **`service`:** Camada de Regras de Negócio, onde estão a lógica dos verbos HTTP. 
* **`controller`:** A camada de interface REST, responsável por mapear as requisições HTTP.

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Java Development Kit (JDK) instalado (versão 17+ recomendada).
* Maven instalado (ou Gradle).
* Uma IDE como IntelliJ IDEA ou VS Code.

### Passos de Execução

1.  **Clone o Repositório** (se for o caso) ou abra a pasta do projeto na sua IDE.
2.  **Gerencie as Dependências:** Certifique-se de que sua IDE (ex: IntelliJ) importou as dependências do arquivo `pom.xml` e compilou o projeto com sucesso.
3.  **Execute a Aplicação:** Execute a classe principal `FilmesApiApplication.java`).

A API estará acessível em `http://localhost:8080`.

### Acesso ao Banco H2 (Apenas em Desenvolvimento)

O projeto está configurado para usar o H2 em memória. Você pode visualizar os dados acessando o console:

* **URL do Console:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:filmesdb`
* **Username:** `sa`
* **Password:** 

---

## 🔗 Endpoints da API (CRUD Completo)

O recurso principal mapeado é `/filmes`. Todos os endpoints solicitados foram implementados, incluindo a atualização parcial (`PATCH`).

| Método | Rota | Descrição | Status HTTP de Sucesso |
| :---: | :--- | :--- | :--- |
| **GET** | `/filmes` | Retorna todos os filmes. | `200 OK` |
| **GET** | `/filmes/{id}` | Retorna um filme específico por ID. | `200 OK` / `404 Not Found` |
| **POST** | `/filmes` | Cria um novo registro de filme. | `201 Created` |
| **PUT** | `/filmes/{id}` | Atualiza **completamente** um filme. | `200 OK` / `404 Not Found` |
| **DELETE** | `/filmes/{id}` | Deleta um registro por ID. | `204 No Content` / `404 Not Found` |
| **PATCH** | `/filmes/{id}` | Atualiza **parcialmente** um filme (apenas campos enviados). | `200 OK` / `404 Not Found` |

---

## 🎬 Entidade `Filme`

A estrutura de dados da entidade principal:

| Atributo | Tipo | Restrições |
| :--- | :--- | :--- |
| `id` | `Long` | Chave Primária, Auto-Gerada |
| `titulo` | `String` | Não Nulo, Máx. 150 caracteres |
| `anoLancamento` | `Integer` | Não Nulo |
| `diretor` | `String` | Não Nulo, Máx. 100 caracteres |
| `genero` | `String` | Opcional, Máx. 50 caracteres |
| `sinopse` | `String` | Texto Longo (TEXT) |

---

## ⏭️ Próximos Passos (Melhorias Futuras)

Para levar o projeto ao próximo nível, pode-se implementar:

* Uso de **DTOs** (Data Transfer Objects) para desacoplar a Entidade do Controller.
* **Tratamento Global de Exceções** (`@ControllerAdvice`).
* **Validação de Dados** com anotações de Bean Validation.

Será uma melhoria que farei posteriormente.

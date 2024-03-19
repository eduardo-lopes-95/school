### 1. Criar uma Escola

- **Endpoint:** `POST /api/escola/create`
- **Descrição:** Cria uma nova escola com base nos dados fornecidos no corpo da requisição.
- **Parâmetros de Entrada:**
  - `request`: Um objeto JSON contendo os detalhes da escola a ser criada.
- **Exemplo de Requisição:**
  ```json
  POST /api/escola/create
  Content-Type: application/json

  {
    "nome": "Nome da Escola",
    "cep": "Cep da Escola"
  }
  
  {
	"nome": "Escola Primária",
	"cep": "12345678",
	"professores": [
		{
			"nome": "João da Silva",
			"materia": "Matemática"
		},
		{
			"nome": "Maria Oliveira",
			"materia": "Português"
		}
    ]
  }

### 2. Obter Todas as Escolas

- **Endpoint:** `GET /api/escola`
- **Descrição:** Retorna todas as escolas cadastradas.
- **Exemplo de Requisição:**
  ```http
  GET /api/escola


### 3. Obter Escola por ID

- **Endpoint:** `GET /api/escola/{id}`
- **Descrição:** Retorna uma escola específica com base no ID fornecido.
- **Parâmetros de Path:**
  - `id`: ID da escola a ser recuperada.
- **Exemplo de Requisição:**
  ```http
  GET /api/escola/1

### 4. Atualizar Escola

- **Endpoint:** `PUT /api/escola/{id}`
- **Descrição:** Atualiza os detalhes de uma escola existente com base no ID fornecido.
- **Parâmetros de Path:**
  - `id`: ID da escola a ser atualizada.
- **Parâmetros de Entrada:**
  - `request`: Um objeto JSON contendo os detalhes atualizados da escola.
- **Exemplo de Requisição:**
  ```json
  PUT /api/escola/1
  Content-Type: application/json

  {
    "nome": "Novo Nome da Escola",
    "cep": "Cep da Escola"
  }

### 5. Deletar Escola

- **Endpoint:** `DELETE /api/escola/{id}`
- **Descrição:** Exclui uma escola com base no ID fornecido.
- **Parâmetros de Path:**
  - `id`: ID da escola a ser excluída.
- **Exemplo de Requisição:**
  ```http
  DELETE /api/escola/1


# Documentação da Controller ProfessorController

A `ProfessorController` é responsável por fornecer endpoints REST para lidar com operações relacionadas a professores em um sistema de gerenciamento escolar.

## Endpoints Disponíveis

### 1. Criar um Professor

- **Endpoint:** `POST /api/professor/create`
- **Descrição:** Cria um novo professor com base nos dados fornecidos no corpo da requisição.
- **Parâmetros de Entrada:**
    - `request`: Um objeto JSON contendo os detalhes do professor a ser criado.
- **Exemplo de Requisição:**
  ```json
  POST /api/professor/create
  Content-Type: application/json

  {
    "nome": "João Silva",
    "disciplina": "Matemática",
    "email": "joao.silva@example.com",
    "escolaId": 123
  }

**Exemplo de Resposta (Sucesso):**
- **Exemplo de Requisição:**
HTTP/1.1 201 Created
```json
{
"id": 1,
"nome": "João Silva",
"disciplina": "Matemática",
"email": "joao.silva@example.com",
"escolaId": 123
}
```

### Listar todos os Professores de uma Escola

- **Endpoint:** `GET /api/professor/{escola_id}/list`
- **Descrição:** Retorna uma lista de todos os professores associados a uma escola específica.
- **Parâmetros de Entrada:**
    - `escola_id`: O ID da escola para a qual deseja-se listar os professores.
- **Exemplo de Requisição:**
- ***Endpoint:*** `GET /api/professor/123/list`

- **Exemplo de Resposta (Sucesso):**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "disciplina": "Matemática",
    "email": "joao.silva@example.com",
    "escolaId": 123
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "disciplina": "História",
    "email": "maria.souza@example.com",
    "escolaId": 123
  }
]
```

### 3. Obter um Professor por ID

- **Endpoint:** `GET /api/professor/{id}`
- **Descrição:** Retorna as informações de um professor específico com base no ID fornecido.
- **Parâmetros de Entrada:**
  - `id`: O ID do professor desejado.
- **Exemplo de Requisição:**

- **Exemplo de Resposta (Sucesso):**
```json
HTTP/1.1 200 OK

{
  "id": 1,
  "nome": "João Silva",
  "disciplina": "Matemática",
  "email": "joao.silva@example.com",
  "escolaId": 123
}
```

### 4. Atualizar um Professor

- **Endpoint:** `PUT /api/professor/{id}`
- **Descrição:** Atualiza as informações de um professor específico com base no ID fornecido.
- **Parâmetros de Entrada:**
  - `id`: O ID do professor a ser atualizado.
  - `request`: Um objeto JSON contendo os detalhes atualizados do professor.
- **Exemplo de Requisição:**
```json
PUT /api/professor/1
Content-Type: application/json

{
"nome": "João Silva",
"disciplina": "Física",
"email": "joao.silva@example.com",
"escolaId": 123
}
```
  
- **Exemplo de Resposta (Sucesso):**
```
HTTP/1.1 200 OK

{
"id": 1,
"nome": "João Silva",
"disciplina": "Física",
"email": "joao.silva@example.com",
"escolaId": 123
}
```

### 5. Deletar um Professor

- **Endpoint:** `DELETE /api/professor/{id}`
- **Descrição:** Exclui um professor específico com base no ID fornecido.
- **Parâmetros de Entrada:**
    - `id`: O ID do professor a ser excluído.
- **Exemplo de Requisição:**

DELETE /api/professor/1

- **Exemplo de Resposta (Sucesso):**

```json
HTTP/1.1 200 OK

"Professor deleted successfully!."
```

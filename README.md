# Projeto School Management
Essa API gerencia operações relacionadas a alunos dentro de um sistema escolar. 
Lida com solicitações HTTP relacionadas a alunos, incluindo listagem, criação, atualização e exclusão de registros de alunos. 
Também fornece endpoints para recuperar alunos por seus IDs ou CPFs (Número de Registro de Contribuinte Individual brasileiro) e para incrementar idades de alunos.

## Endpoints

### Listar Alunos
- **URL:** `/aluno`
- **Método:** `GET`
- **Descrição:** Recupera uma lista de todos os alunos.
- **Resposta:** Retorna uma matriz JSON de objetos `AlunoDto` representando os alunos.

### Obter Aluno por ID
- **URL:** `/aluno/{id}`
- **Método:** `GET`
- **Descrição:** Retorna um aluno pelo seu ID.
- **Parâmetros:**
  - `id`: O ID do aluno.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno.

### Obter Aluno por CPF
- **URL:** `/aluno/cpf/{cpf}`
- **Método:** `GET`
- **Descrição:** Retorna um aluno pelo seu CPF.
- **Parâmetros:**
  - `cpf`: O CPF do aluno.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno.

### Criar Aluno
- **URL:** `/aluno`
- **Método:** `POST`
- **Descrição:** Cria um novo aluno.
- **Corpo da Requisição:** Objeto JSON de `AlunoDto` representando o aluno a ser criado.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno criado.

### Incrementar Idades dos Alunos
- **URL:** `/aluno/aniversario/{id}`
- **Método:** `POST`
- **Descrição:** Incrementa a idade do aluno identificado pelo ID fornecido.
- **Parâmetros:**
  - `id`: O ID do aluno.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno atualizado.

### Atualizar Aluno
- **URL:** `/aluno/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza um aluno existente.
- **Parâmetros:**
  - `id`: O ID do aluno a ser atualizado.
- **Corpo da Requisição:** Objeto JSON de `AlunoDto` representando as informações atualizadas do aluno.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno atualizado.

### Excluir Aluno por ID
- **URL:** `/aluno/{id}`
- **Método:** `DELETE`
- **Descrição:** Exclui um aluno pelo seu ID.
- **Parâmetros:**
  - `id`: O ID do aluno a ser excluído.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno excluído.

### Excluir Aluno por CPF
- **URL:** `/aluno/cpf/{cpf}`
- **Método:** `DELETE`
- **Descrição:** Exclui um aluno pelo seu CPF.
- **Parâmetros:**
  - `cpf`: O CPF do aluno a ser excluído.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno excluído.

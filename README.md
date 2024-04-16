# Projeto School Management
Essa API gerencia operações relacionadas a alunos dentro de um sistema escolar. 
Lida com solicitações HTTP relacionadas a alunos, incluindo listagem, criação, atualização e exclusão de registros de alunos. 
Também fornece endpoints para recuperar alunos por seus IDs ou CPFs (Número de Registro de Contribuinte Individual brasileiro) e para incrementar idades de alunos.

### Autenticação
A autenticação é necessária para algumas operações na API. Use as seguintes credenciais para autenticar:

- **Admin:**
  - Usuário: `admin`
  - Senha: `admin`

- **Usuário Seguro:**
  - Usuário: `UsuarioSeguro`
  - Senha: `SenhaSegura`

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
- **Autenticação:** Admin ou Usuário Seguro
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno criado.

### Incrementar Idades dos Alunos
- **URL:** `/aluno/aniversario/{id}`
- **Método:** `POST`
- **Descrição:** Incrementa a idade do aluno identificado pelo ID fornecido.
- **Parâmetros:**
  - `id`: O ID do aluno.
- **Resposta:** Retorna um objeto JSON de `AlunoDto` representando o aluno atualizado.

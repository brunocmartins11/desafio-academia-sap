# Desafio: Gerenciador de Cursos Online com API CRUD

Repositório para projeto de gerenciamento de cursos online, com o objetivo de realizar as operações de CRUD (Create, Read, Update, Delete) e permitir que os usuários (alunos) possam se inscrever em cursos. A aplicação utiliza Spring MVC para o Backend, Hibernate para o mapeamento objeto-relacional (ORM), H2 como banco de dados e implementa endpoints REST para o gerenciamento dos dados.

## Tecnologias Utilizadas

Para a realização deste projeto, foram utilizadas as seguintes tecnologias:

- Java Development Kit 23;
- Spring MVC: Para a criação do Backend e exposição dos endpoints REST.
- Hibernate: Para o mapeamento objeto-relacional (ORM) com o banco de dados.
- H2 Database: Banco de dados em memória para armazenamento de dados.
- DTOs (Data Transfer Objects): Para transferir dados entre o Controller e a camada de serviço, evitando a exposição direta das entidades.

## Como Utilizar ?

### Passo 1: Clonar o Repositório
Clone o repositório para o seu ambiente local:


```bash
git clone https://github.com/seu-usuario/desafio-academia-sap.git
cd desafio-academia-sap
```

### Passo 2: Instalar Dependências
Instale as dependências do projeto utilizando o Maven:

```bash
mvn clean install
```

### Passo 3: Executar o Projeto
Para rodar a aplicação, utilize o comando Maven:

```bash
mvn spring-boot:run
```
O servidor será iniciado e estará disponível nas seguintes portas:

- Backend (API REST): http://localhost:8080/
- Banco de Dados (H2 Console): http://localhost:8080/h2-console (pode ser acessado para visualização e manipulação dos dados no banco de dados H2)

Para utilizar o projeto, após clonar esse repositório, primeiro instale as dependências utilizando o código abaixo:

### Passo 4: Testar a API
Abaixo estão os endpoints disponíveis para interação com a API:

#### Cadastrar Aluno

POST http://localhost:8080/alunos

```json
{
  "nome": "Nome do Aluno",
  "email": "email@dominio.com"
}
```
#### Cadastrar Curso

POST http://localhost:8080/cursos

```json
{
  "nome": "Nome do Curso",
  "descricao": "Descrição do Curso"
}
```
#### Inscrever Aluno em Curso

POST http://localhost:8080/alunos/{alunoId}/inscrever/{cursoId}

```json
{
  "aluno_id": 1,
  "curso_id": 2
}
```

#### Listar Cursos de um Aluno

GET http://localhost:8080/alunos/{alunoId}/cursos

#### Listar Alunos de um Curso

GET http://localhost:8080/cursos/{cursoId}/alunos
## Exemplos de JSON Utilizados
#### Cadastrar Aluno
```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com"
}
```
#### Cadastrar Curso
```json
{
  "nome": "Java para Iniciantes",
  "descricao": "Curso introdutório de Java."
}
```

#### Inscrição de Aluno em Curso
```json
{
  "aluno_id": 1,
  "curso_id": 2
}
```

## Autor

<table>
  <tr>
  <td align="center">
      <a href="https://github.com/brunocmartins11" title="Bruno Martins">
        <img src="https://avatars.githubusercontent.com/u/101012137?v=4" width="100px;" alt="Foto de Bruno Martins"/><br>
        <sub>
          <b>Bruno Martins</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

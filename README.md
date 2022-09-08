# 📜 Lista de tarefas

Aplicativo feito para organizar suas tarefas, podendo criar, listar, editar e remover elas por meio de chamadas HTTP.

API RESTful feita com Java 8, Jax-RS e Hibernate.

## Rotas

| **Método** | **Endpoint** |        **Descrição**        |        **Corpo da requisição**       |
|:----------:|:------------:|:---------------------------:|:------------------------------------:|
| GET        | /tarefas     | Lista todas as tarefas      | -                                    |
| GET        | /tarefas/:id | Lista uma tarefa específica | -                                    |
| POST       | /tarefas     | Cria uma nova tarefa        | JSON com as informações da tarefa    |
| PUT        | /tarefas/:id | Atualiza uma tarefa         | JSON com quais informações atualizar |
| DELETE     | /tarefas/:id | Deleta uma tarefa           | -                                    |

## Banco de Dados

Foi utilizado o banco de dados MySQL 8.0. O script para a criação do banco de dados se encontra no arquivo ``database.sql``.

O banco consiste de apenas uma tabela, chamada tarefa, com informações da tarefa como título, descrição, prioridade, se já foi completada, data em que foi criada e que a tarefa expira.


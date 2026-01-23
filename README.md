- Pré-requisitos:

Antes de executar o projeto localmente, instale: Java 17, Maven, Docker, Docker Compose.

- Execução:

Clonar o projeto usando git clone https://github.com/Marchitations/aerobase-api.git

Executar o banco PostgreSQL da aplicação, que está configurado para rodar via docker. Para isso, na raiz do projeto, utilize o comando docker compose up -d

Após inicialização do banco, execute o back-end da aplicação. É possível subir o back-end da aplicação executando o comando mvn spring-boot:run pelo terminal estando na pasta do projeto, ou executar a classe principal BackendApplication na IDE. O back-end estará disponível na porta 8080.

- Documentação:

Acessar o Swagger da aplicação através da URL: http://localhost:8080/swagger-ui/index.html

- Arquitetura:

Este projeto foi desenvolvido utilizando arquitetura RESTful, com separação de responsabilidades entre as camadas da aplicação (controller, service, repository, model, DTO e mapper). O principal objetivo dessa escolha é garantir organização, legibilidade, e facilidade de desenvolvimento de novas funcionalidades no código.
O projeto utilizas boas práticas, como código limpo, uso adequado de todos os verbos HTTP, utilização de códigos de status HTTP, separação de DTOs por operação (create, edit, response), validação de dados no DTO para controle de campos obrigatórios e formatos inválidos, banco de dados executado via Docker, garantindo facilidade para que outros desenvolvedores possam rodar localmente o ambiente da aplicação

- Funcionalidades Extras:

Foi implementado exclusão lógica de aeronaves através da coluna "deletado" no banco, que guarda a data e hora de exclusão e essa aeronava não é mais mostrada na aplicação porém continua guardada no banco.

Modelo de negócios implementados, impossibilitando o usuário de criar uma aeronave cujo ano de fabricação é maior que o ano atual. Ademais aeronaves vendidas deixam de serem editáveis.

Implementada tabela de histórico de modificações contendo o campo atualizado, o valor antigo, valor atual e data e hora da modificação.
Spring Boot RESTFul API para Realizar Transacoes
REST APIs implementada utilizando Spring Boot e H2 Database.

Como executar?
Está aplicação está utilizando um servidor Tomcat embutido rodando na porta 8080. Não é necessário instalação do Tomcat.

Clone este repositório

Para realizar o build do projeto e rodar apliccação, você pode esta acessando o SWAGGER.

`localhost:8080//mini-autorizador/swagger`
Você também pode acessar o console da base de dados H2 acessando 

REST APIs Endpoints
Cria Cliente /v1/cliente (POST)
Lista Clientes /v1/cliente (GET)
Lista Cliente /v1/cliente/{idCliente} (GET)

Cria Cartao: /v1/cliente/{idCliente}/cartao (POST)
Listar os Cartoes: /v1/cliente/{idCliente}/{numeroCartao}/cartao (GET)
Realizar Transacao /v1/cliente/{idCliente}/cartao/realizaTransacao (POST)
Para Realizar o build do Projeto Você pode estar rodando a documentação completa da API no Swagger.
Execute o servidor e acesse o navegador em: localhost:8080/mini-autorizador/swagger
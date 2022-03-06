# API_Vaga_Estacionamento


[![GitHub](https://img.shields.io/github)](https://github.com/Luizcesar-dev/API_Vaga_Condominio/blob/main/LICENSE)

# Sobre o projeto:

Apicação Backend desenvolvida em liguagem JAVA, utilizando o framework Spring Boot e conexão com banco de dados Oracle.

A aplicação  consiste em efetuar procedimentos de CAdastro, consulta, atualização e exclusão de vagas de estacionamento para um condomínio em que o morador terá direito a uma vaga reservada para seu veículo

# Tecnologias Utilizadas:
## Back End
- JAVA
- Spring Boot Franework
- Spring MVC
- Sprong Data JPA
- Spring_validations
- Lombok

## Front End


# Cronograma para Implementacção de Melhorias
## Back end
- Controle de acesso por usuário e senha
- Altenticação por token (JWT)

## Front End
- Implementação de interface para acesso de usuários e registr de vagas

# Pré-requisitos:
- JAVA 11 ou superior
- Banco de dados Oracle XE
- Postman para teste da API

# Como testar:
#### Este API poissui 5 métodos de requisições:
- GET
- GET/{id}
- POST
- PUT/{id}
- DELETE

>__Rota para requisição:__
>*localhost:8085/api/vaga_estacionamento/vagas/*

os dados de entrada e são são no formato JSON.

#### Exoemplo de entrada:
~~~ jSON
{
"bloco" : "1",
"corVeiculo": "prata",
"descricaoVeiculo": "voyage 2010 5p",
"marcaVeiculo": "Volksvagem",
"modeloVeiculo": "Sedan",
"nomeProprietario": "Thomas Oliveira",
"numApartamento": "102A",
"numeroVaga": "2",
"placaVeiculo": "ABD1G34",
"quadra": "2" 
}
~~~
Os registros são armazenados na tabela TB_VAGA_ESTACIONAMENTO:

CAMPO         |    TIPO
:--------------|:--------------:
ID                 | Auto-incremento
DataRegistro       | Timestamp
numeroVaga         | VARCHAR2(7)
placaVeiculo       | VARCHAR2(7)
marcaVeiculo       | VARCHAR2(30)
modeloVeiculo      | VARCHAR2(30)
descricaoVeiculo   | VARCHAR2(70)
corVeiculo         | VARCHAR2(50)
nomeProprietario   | VARCHAR2(100)
numeroVaga         | VARCHAR2(10)
bloco              | VARCHAR2(10)
quadra             | VARCHAR2(10)

As configurações de porta de acesso e conexão co o banco de dados é realizada no arquivo __application.properties__, localizado no diretório ..\ControleEstacionamento\src\main\resources 

~~~~ JAVA
server.port=8085
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:<INSTANCE>
spring.datasource.username=<USER>
spring.datasource.password=<PASSWORD>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
~~~~

## Autor
Luiz Cesar Oliveira
Desenvoldor Pleno


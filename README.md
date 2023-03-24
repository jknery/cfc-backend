# CFC-BACKEND
## API REST - CONTROLE DE FLUXO DE CAIXA E CONSOLIDAÇÕES


Projeto base Back-end para CONTROLE DE FLUXO DE CAIXA E CONSOLIDAÇÕES

## LOCAL

## Getting Started

Para iniciar o projeto siga as instruções seguintes.

* [Github](https://github.com/)
* [Java SE Development Kit 17](https://www.oracle.com/)
* [Maven 3.x](https://maven.apache.org/)

## Instalação

Após instalar todos os pré-requisitos necessários, execute os próximos passos para conseguir disponibilizar a aplicação no seu ambiente local de desenvolvimento.

```sh
# Clone o repositório do projeto
$ git clone https://github.com/jknery/cfc-backend.git
# Navegue até a pasta root da aplicação
$ cd cfc-backend
# Instale todas as dependências
$ mvn clean install
```

## Executando a Aplicação

Importe o projeto em uma IDE de suas preferência.

> **importante:** Para o desenvolvimento do projeto base utilizei o Eclipse.

Agora build a aplicação na sua IDE.

```sh
# Maven goals
$  clean install
```

run java class CfcBackendApplication

> **importante:** O contexto da aplicação é **//cfc-backend//api//v1**.


## Swagger UI

Para acessar o Swagger UI, abra o seguinte link no seu navegador: http://localhost:8080/cfc-backend/api/v1/swagger-ui.html


## CLOUD - exemplo heroku

Adiciona-se arquivo Procfile, contendo: 

    -- web: java -jar target/cfc-backend-0.0.1-SNAPSHOT.jar

com a conta devidamente criada, e adicionados os remotes.
    -- git push heroku master

## Constrúido com

* [Maven](https://maven.apache.org/) - Gerenciador de dependências

## Autor

* **JOSÉ IVO KOERICH NERY** - *TECH LEAD JAVA*
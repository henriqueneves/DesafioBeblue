# Desafio Beblue - Engenheiro Back-end

Desafio para ingresso como desenvolvedor back-end no Beblue.

### Tecnologias
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database Engine](https://www.h2database.com/) (banco de dados)
- [Spotify Web APL Librarie Java](https://github.com/thelinmichael/spotify-web-api-java)

## Instruções de execução

### Clone
```git clone https://github.com/henriqueneves/DesafioBeblue.git```

### Build
```mvn clean install```

### Executar (Maven ou Docker)
- Maven
  ```mvn spring-boot:run```

- Docker
  ```docker build -t desafio .
  docker run -p 8080:8080 desafio```

## Documentação

### Discos
* Importação: importando discos do Spotify
  * Content-Type: application/json
  * GET: [http://localhost:8080/api/disco/importar](http://localhost:8080/api/disco/importar)
  
* Todos os discos: retorna todos os discos sem paginação e filtros
  * Content-Type: application/json
  * GET: [http://localhost:8080/api/disco/](http://localhost:8080/api/disco/)
  
* Busca paginada: retorna N discos de determinado gênero utilizando filtros
  * Content-Type: application/json
  * Parâmetros obrigatórios: generoMusical
  * Parâmetros opcionais: pagina, tamanho, ordenarPor, ordem  
  * GET: [http://localhost:8080/api/disco/buscar?generoMusical=**rock**&pagina=**1**&tamanho=**10**&ordenarPor=**nome**&ordem=**ASC**](http://localhost:8080/api/disco/buscar?generoMusical=rock&pagina=1&tamanho=10&ordenarPor=nome&ordem=ASC)
  
 * Buscar disco por identificador
   * Content-Type: application/json
   * GET: [http://localhost:8080/api/disco/buscar/**5**](http://localhost:8080/api/disco/buscar/5)
   
### Vendas
* Nova venda: cria uma venda. Deve-se enviar um JSON com os identificadores dos discos, seguindo o padrão do exemplo onde é criada uma nova venda de três discos (25, 45 e 100).
  * Content-Type: application/json
  * POST: [http://localhost:8080/api/venda/nova](http://localhost:8080/api/venda/nova)
  * Exemplo BODY - RAW:
  ```
  {
     "vendaDiscos":[
        {
           "disco":{
              "id":25
           }
        },
  	  {
           "disco":{
              "id":45
           }
        },
  	  {
           "disco":{
              "id": 100
           }
        }
     ]
  }
  ```

* Todos as vendas: retorna todas as vendas sem paginação e filtros
  * Content-Type: application/json
  * GET: [http://localhost:8080/api/venda/](http://localhost:8080/api/venda/)
  
* Busca paginada: retorna de forma paginada N vendas filtrando por data de início e fim
  * Content-Type: application/json
  * Parâmetros obrigatórios: dataInicial, dataFinal
  * Parâmetros opcionais: pagina, tamanho, ordenarPor, ordem  
  * GET: [http://localhost:8080/api/venda/buscar?dataInicial=**2019-05-01**&dataFinal=**2019-05-20**&pagina=**0**&tamanho=**10**&ordenarPor=**registroDaVenda**&ordem=**DESC**](http://localhost:8080/api/venda/buscar?dataInicial=2019-05-01&dataFinal=2019-05-20&pagina=0&tamanho=10&ordenarPor=registroDaVenda&ordem=DESC)
  
* Buscar venda por identificador
  * Content-Type: application/json
  * GET: [http://localhost:8080/api/venda/buscar/**3**](http://localhost:8080/api/venda/buscar/3)
   
## Observações:

* Para testar a API recomenda-se o uso de um API Client.
* Para facilitar os testes, as tabelas do banco de dados são recriadas a cada execução.
* A API não exige autenticação para acesso as suas funcionalidades.
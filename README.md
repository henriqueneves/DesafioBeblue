# Desafio Beblue - Engenheiro Back-end

Desafio para ingresso como desenvolvedor back-end no Beblue. Requisitos do projeto.

### Tecnologias
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database Engine](https://www.h2database.com/) (banco de dados)
- [Spotify Web APL Librarie Java](https://github.com/thelinmichael/spotify-web-api-java)

## Instruções de execução

### Clone
```git clone https://github.com/henriqueneves/DesafioBeblue.git```

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
  * GET: [http://localhost:8080/api/disco/buscar?genero=**rock**&pagina=**1**&tamanho=**10**](http://localhost:8080/api/disco/buscar?genero=rock&pagina=1&tamanho=10)
  
 * Buscar disco por identificador
   * Content-Type: application/json
   * GET: [http://localhost:8080/api/disco/buscar/**5**](http://localhost:8080/api/disco/buscar/5)
   
 ### Vendas

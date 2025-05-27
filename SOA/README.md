# Sistema SOA - Tendência de Nomes no Brasil

Este projeto utiliza arquitetura SOA para consultar a API de nomes do IBGE, permitindo analisar tendências de nomes ao longo das décadas.

## Funcionalidades

1. **Evolução do ranking de um nome**
2. **Comparação entre dois nomes**
3. **Ranking de nomes por localidade**

## Tecnologias

- Java 17
- Spring Boot 3.2
- Swagger (via SpringDoc)
- REST API
- Chart.js (gráficos no frontend)

## Execução

1. `./mvnw spring-boot:run`
2. Acesse `http://localhost:8080/swagger-ui.html`
3. Acesse o `index.html` localmente (ou configure como recurso estático)

## Estrutura SOA

- `Controller`: expõe endpoints REST
- `Service`: consome a API IBGE e processa dados
- `Model`: representa a estrutura dos dados da API

## Alunos

Kauan Henrique Bertalha RA:22262074-2
Matheus Toscano Rossini RA: 22212262-2
Willyan Santos Tomaz e Silva RA: 22014128-2
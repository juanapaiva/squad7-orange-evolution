# Squad 07 - Orange Evolution

Orange Evolution é uma plataforma onde qualquer pessoa pode ter acesso a trilhas com conteúdos gratuitos, organizados por temas e por skills, sendo: Desenvolvimento Full Stack, UX/UI Design e Quality Assurance (QA).

## Sobre :book: 

#### :gear: Tecnologias utilizadas:

- **Front-end:** HTML, CSS e Javascript. **Framework:** Bootstrap
- **Back-end:** Java com Spring Boot
- **Banco de Dados:** MySQL

### :computer: Como Funciona?

### 📋 Instalação e uso

Pré-requisitos: [Java (JDK ^11)](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) | [Apache Maven (^3.8)](https://maven.apache.org/download.cgi) | [MySQL Workbench](https://www.mysql.com/products/workbench/?p=857) | [Docker Desktop](https://docs.docker.com/desktop/install/windows-install/)

1.  Uma vez cumpridos todos os pré-requisitos e clonado o repositório, abrir/rodar o Docker Desktop, entrar na pasta do projeto via terminal e executar o comando abaixo para baixar a imagem do container com o banco de dados:

    ```
    docker-compose up
    ```

2.  Conectar o banco de dados MySQL Workbench:

    ```
    Hostname: localhost
    Port: 3306
    Username: root
    Password: root
    ```

3.  Executar os scripts presentes na pasta MySQL_scripts na seguinte ordem, assim gerando as tabelas:

    ```
    1. create_database_script.sql
    2. insert_roadmaps_script.sql
    3. insert_contents_script.sql
    4. insert_users_script.sql
    5. insert_interests_script.sql
    6. insert_roadmaps_users_script.sql
    7. insert_interests_users_script.sql
    8. insert_content_status_script.sql
    ```

4.  Rodar no terminal o comando abaixo para a execução do projeto:
    ```
    mvn spring-boot:run
    ```
5.  Acessar no navegador a página através do endereço:
    ```
    http://localhost:8080
    ```

### :octocat: Contribuidores 
- **UX/UI Design: Aline Aleixo**
- **Desenvolvedores: Bruno Pacheco, Juana Paiva**
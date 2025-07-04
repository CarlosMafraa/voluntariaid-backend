# Voluntariaid Backend

Backend da aplicação Voluntariaid para cadastro de voluntários e missões sociais.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **Spring Boot Validation**
- **MySQL 8.0**
- **SpringDoc OpenAPI** (Swagger)
- **Docker & Docker Compose**

## 📋 Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- [Java 21+](https://adoptium.net/)
- [Maven 3.6+](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## 🛠️ Configuração do Ambiente

### 1. Configuração do Banco de Dados

**⚠️ IMPORTANTE:** Antes de iniciar a aplicação Spring Boot, é necessário subir o banco de dados MySQL usando Docker Compose.

Execute o comando abaixo na raiz do projeto:

```bash
docker-compose up -d
```

Este comando irá:
- Criar um container MySQL 8.0
- Configurar o banco de dados `voluntariaid_db`
- Criar o usuário `voluntariaid_user`
- Executar scripts de inicialização (se existirem em `./docker/mysql/init.sql`)
- Expor o banco na porta `3306`

### 2. Verificar se o Banco Está Funcionando

Para verificar se o MySQL está rodando corretamente:

```bash
docker-compose ps
```

Ou verifique os logs:

```bash
docker-compose logs mysql_db
```

### 3. Configuração da Aplicação

Configure as propriedades da aplicação no arquivo `application.properties`:

```properties
# Configurações do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/voluntariaid_db
spring.datasource.username=voluntariaid_user
spring.datasource.password=voluntariaid_password

# Configurações do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update

# Configurações do SpringDoc/Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

## 🏃‍♂️ Como Executar

### Passo 1: Subir o Banco de Dados
```bash
docker-compose up -d
```

### Passo 2: Executar a Aplicação
```bash
mvn spring-boot:run
```

Ou compile e execute:
```bash
mvn clean package
java -jar target/voluntariaid-backend-0.0.1-SNAPSHOT.jar
```

## 📚 Documentação da API

Após iniciar a aplicação, a documentação da API estará disponível em:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

## 🗄️ Estrutura do Banco de Dados

O banco de dados `voluntariaid_db` será criado automaticamente com as seguintes configurações:

- **Host**: localhost
- **Porta**: 3306
- **Database**: voluntariaid_db
- **Usuário**: voluntariaid_user
- **Senha**: voluntariaid_password
- **Usuário Root**: root (senha: rootpassword)

## 🔧 Comandos Úteis

### Docker Compose
```bash
# Iniciar containers
docker-compose up -d

# Parar containers
docker-compose down

# Ver logs
docker-compose logs -f

# Reiniciar apenas o MySQL
docker-compose restart mysql_db
```

### Acessar MySQL diretamente
```bash
# Via Docker
docker exec -it app_mysql mysql -u voluntariaid_user -p voluntariaid_db

# Via cliente MySQL local
mysql -h localhost -P 3306 -u voluntariaid_user -p voluntariaid_db
```

## 🚨 Solução de Problemas

### Erro de Conexão com o Banco
1. Verifique se o Docker está rodando
2. Confirme se o container MySQL está ativo: `docker-compose ps`
3. Verifique se a porta 3306 não está sendo usada por outro serviço

### Erro de Permissões
Se encontrar problemas de permissão, certifique-se de que o Docker tem as permissões necessárias no seu sistema.

### Limpeza Completa
Para remover completamente o ambiente:
```bash
docker-compose down -v
docker system prune -f
```

## 📖 Desenvolvimento

### Estrutura do Projeto
```
voluntariaid-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── docker/
│   └── mysql/
│       └── init.sql
├── docker-compose.yml
├── pom.xml
└── README.md
```

### Perfis de Ambiente
Considere criar diferentes perfis para desenvolvimento, teste e produção:

- `application-dev.properties`
- `application-test.properties`
- `application-prod.properties`

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

**Desenvolvido com ❤️ para conectar voluntários e causas sociais**
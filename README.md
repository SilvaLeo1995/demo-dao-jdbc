# Sales Management JDBC

Projeto Java para gerenciamento de vendedores (`Seller`) e departamentos (`Department`) utilizando JDBC e o padrão DAO (Data Access Object).

## 📝 Descrição

Este sistema permite realizar operações CRUD básicas (criar, ler, atualizar e deletar) para as entidades `Seller` e `Department`. O projeto está estruturado com boas práticas de programação orientada a objetos, abstração de acesso a dados via interfaces DAO e conexão com banco MySQL usando JDBC.

## 🧰 Tecnologias

- Java SE 8+
- JDBC
- MySQL (ou outro banco relacional compatível)
- Padrão DAO e Factory
- IDEs recomendadas: IntelliJ, Eclipse, VSCode

- ## ⚙️ Configuração do banco de dados

**1.** Crie um banco MySQL chamado `coursejdbc` (ou outro nome que desejar).

**2.** Configure o arquivo `src/resources/db.properties` com as credenciais do seu banco:

```properties
user=root
password=
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false

CREATE TABLE department (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(60) NOT NULL
);

CREATE TABLE seller (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    BirthDate DATE NOT NULL,
    BaseSalary DOUBLE NOT NULL,
    DepartmentId INT,
    FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```
 ## 🚀 Como rodar o projeto
Compile o projeto com sua IDE favorita ou via linha de comando.

Execute a classe principal application.Program. Ela contém testes básicos que demonstram as operações CRUD no console.

 ## 📌 Funcionalidades do projeto
- Listar todos departamentos e vendedores.

- Buscar departamentos e vendedores por ID.

- Inserir, atualizar e deletar departamentos e vendedores.

- Buscar vendedores por departamento.

**Autor**
Leonardo Gabriel — SilvaLeo1995

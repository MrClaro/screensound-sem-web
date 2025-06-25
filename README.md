
# ScreenSound (sem web)

Projeto Java utilizando **Spring Boot**, **JPA** e **PostgreSQL** para gerenciamento de dados musicais, com integração à API Gemini para recursos avançados de IA — **sem interface web**.

---

## 📦 Estrutura do Projeto

```
screensound-sem-web/
│
├── .gitattributes
├── .gitignore
├── .mvn/                # Configuração Maven Wrapper
├── mvnw                 # Maven Wrapper (Linux/Mac)
├── mvnw.cmd             # Maven Wrapper (Windows)
├── pom.xml              # Dependências e build Maven
├── src/
│   ├── main/            # Código-fonte principal (Java)
│   └── test/            # Testes automatizados
```

---

## 🚀 Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/MrClaro/screensound-sem-web.git
   cd screensound-sem-web
   ```

2. **Configure o banco de dados:**
   - Certifique-se de ter o **PostgreSQL** instalado e rodando.
   - Crie um banco de dados, por exemplo:
     ```sql
     CREATE DATABASE screensound;
     ```
   - Ajuste as credenciais e parâmetros de conexão (usuário, senha) em `src/main/resources/application.properties`.

3. **Compile e execute o projeto:**
   ```bash
   ./mvnw spring-boot:run
   ```
   ou, no Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```

---

## ⚙️ Tecnologias Utilizadas

- **Java**  (Spring Boot)
- **Maven** (Gerenciador de dependências)
- **JPA / Hibernate** (Mapeamento objeto-relacional)
- **PostgreSQL** (Banco de dados relacional)
- **Gemini API** (Integração de IA/LLM)
- (Sem interface web — foco em lógica de negócios e integração backend)

---

## 💡 Funcionalidades

- Cadastro, consulta e manipulação de dados musicais via backend
- Persistência de dados com JPA/Hibernate
- Integração com banco de dados PostgreSQL
- Consumo de recursos de IA via Gemini
- Estrutura de projeto pronta para expansão (ex: REST API, testes, etc)

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues ou pull requests com sugestões, melhorias ou correções!

---

## 📄 Licença

Distribuído sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

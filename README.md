# 📊 Sistema Avaliativo

Sistema de avaliação por setores desenvolvido em Java com interface web moderna e responsiva para hospitais e instituições de saúde.

<p align="center">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
<img src="https://img.shields.io/badge/JSP-FF6600?style=for-the-badge&logo=java&logoColor=white" alt="JSP">
<img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white" alt="Bootstrap">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
<img src="https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black" alt="Tomcat">
</p>

## 🎯 Sobre o Projeto

O **Sistema Avaliativo** é uma plataforma web desenvolvida para facilitar a avaliação de setores hospitalares e instituições de saúde. O sistema permite o gerenciamento de setores, questões de avaliação e a realização de avaliações por meio de uma interface intuitiva e segura.

### ✨ Principais Funcionalidades

- **🏥 Gestão de Setores**: Cadastro, edição e listagem de setores hospitalares
- **❓ Gestão de Questões**: Controle completo de perguntas para avaliação
- **📝 Sistema de Avaliação**: Interface dinâmica para avaliação por notas (0-5)
- **📊 Relatórios**: Visualização de médias e quantidades de avaliações por setor
- **🔐 Sistema de Autenticação**: Login seguro para acesso às funcionalidades administrativas
- **📱 Interface Responsiva**: Design moderno e adaptável para todos os dispositivos

## 🚀 Tecnologias Utilizadas

### Backend
- **Java 17+** - Linguagem de programação robusta
- **JSP (JavaServer Pages)** - Tecnologia para páginas web dinâmicas
- **Servlets** - Componentes Java para processamento HTTP
- **JDBC** - Conectividade com banco de dados
- **Apache Tomcat 9** - Servidor de aplicações

### Frontend
- **Bootstrap 5** - Framework CSS responsivo
- **Material Design Icons** - Ícones modernos e intuitivos
- **JavaScript** - Interações dinâmicas no frontend
- **HTML5 & CSS3** - Marcação e estilização modernas

### Banco de Dados
- **MySQL 8.0** - Sistema de gerenciamento de banco de dados relacional
- **Arquitetura MVC** - Padrão Model-View-Controller
- **DAO Pattern** - Padrão de acesso a dados

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java Development Kit (JDK) 17 ou superior**
- **Apache Tomcat 9.0**
- **MySQL 8.0 ou superior**
- **NetBeans IDE** (recomendado) ou outra IDE Java
- **MySQL Connector/J** (driver JDBC)

## ⚙️ Instalação

### 1. Clone ou baixe o projeto
```bash
# Se usando Git
git clone <url-do-repositorio>
cd Sistema_Avaliativo
```

### 2. Configure o banco de dados
Execute o script SQL para criar o banco:

```sql
CREATE DATABASE sistema_avaliacao;
USE sistema_avaliacao;

-- Tabela usuário
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela setor
CREATE TABLE setor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    status ENUM('ativo', 'inativo') DEFAULT 'ativo',
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela questão
CREATE TABLE questao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pergunta TEXT NOT NULL,
    status ENUM('ativo', 'inativo') DEFAULT 'ativo',
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela avaliação
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_setor INT NOT NULL,
    id_questao INT NOT NULL,
    nota INT CHECK (nota BETWEEN 0 AND 10),
    data_avaliacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_setor) REFERENCES setor(id),
    FOREIGN KEY (id_questao) REFERENCES questao(id)
);
```

### 3. Configure a conexão com o banco
Edite o arquivo `src/java/connection/Conexao.java` com suas credenciais:

```java
public Conexao() {
    bd = "jdbc:mysql://localhost:3306/sistema_avaliacao?useUnicode=true&characterEncoding=UTF-8";
    usuario = "seu_usuario";
    senha = "sua_senha";
    con = null;
}
```

### 4. Configure o servidor Tomcat
1. Abra o projeto no NetBeans
2. Configure o servidor Tomcat nas propriedades do projeto
3. Adicione o MySQL Connector/J às bibliotecas do projeto

### 5. Execute o projeto
1. Clique com o botão direito no projeto
2. Selecione **"Run"**
3. O sistema estará disponível em `http://localhost:8080/Sistema_Avaliativo`

## 👤 Dados Iniciais

Para começar a usar o sistema, insira alguns dados iniciais:

### Usuários de Teste
```sql
INSERT INTO usuario (nome, senha) VALUES 
('admin', 'admin123'),
('avaliador', 'aval123');
```

### Setores de Exemplo
```sql
INSERT INTO setor (nome) VALUES 
('Emergência'),
('UTI'),
('Cardiologia'),
('Pediatria');
```

### Questões de Exemplo
```sql
INSERT INTO questao (pergunta) VALUES 
('Como você avalia o atendimento deste setor?'),
('Qual sua satisfação com a limpeza do ambiente?'),
('Como avalia a organização do setor?'),
('Qual sua satisfação com o tempo de espera?');
```

## 🎮 Como Usar

### Avaliação Pública
1. Acesse a página inicial
2. Selecione o setor que deseja avaliar
3. Responda cada pergunta com uma nota de 0 a 5
4. Finalize a avaliação

### Área Administrativa
1. Clique nos ícones de **gestão** (setores ou questões)
2. Faça login com usuário e senha
3. Acesse as funcionalidades:
   - **Cadastrar novos setores ou questões**
   - **Editar registros existentes**
   - **Visualizar relatórios de avaliação**

### Relatórios
- Acesse o **ícone de relatório**
- Visualize por setor: nome, quantidade de avaliações e média das notas

## 🏗️ Estrutura do Projeto

```
Sistema_Avaliativo/
├── src/
│   └── java/
│       ├── connection/
│       │   └── Conexao.java         # Conexão com banco de dados
│       ├── controller/
│       │   ├── AvaliacaoController.java    # Controller de avaliações
│       │   ├── SetorController.java        # Controller de setores
│       │   ├── QuestaoController.java      # Controller de questões
│       │   └── UsuarioController.java      # Controller de usuários
│       ├── dao/
│       │   ├── AvaliacaoDAO.java          # Acesso a dados de avaliações
│       │   ├── SetorDAO.java              # Acesso a dados de setores
│       │   ├── QuestaoDAO.java            # Acesso a dados de questões
│       │   └── UsuarioDAO.java            # Acesso a dados de usuários
│       └── vo/
│           ├── AvaliacaoVO.java           # Value Object de avaliações
│           ├── SetorVO.java               # Value Object de setores
│           ├── QuestaoVO.java             # Value Object de questões
│           ├── UsuarioVO.java             # Value Object de usuários
│           └── RelatorioSetorVO.java      # Value Object para relatórios
├── web/
│   ├── HomeAvaliacao.jsp       # Página inicial
│   ├── Avaliacao.jsp          # Interface de avaliação
│   ├── ExibeSetores.jsp       # Listagem de setores
│   ├── ExibeQuestoes.jsp      # Listagem de questões
│   ├── ExibeRelatorio.jsp     # Relatórios
│   ├── CadastroSetor.jsp      # Cadastro de setores
│   ├── CadastroQuestao.jsp    # Cadastro de questões
│   ├── css/
│   │   └── style.css          # Estilos personalizados
│   ├── img/                   # Imagens do sistema
│   └── WEB-INF/
│       └── web.xml           # Configurações do servlet
└── README.md
```

## 🔧 Funcionalidades Detalhadas

### Sistema de Avaliação Dinâmica
- **Interface progressiva**: Uma pergunta por vez
- **Notas de 0 a 5**: Sistema de avaliação padronizado
- **Feedback visual**: Mensagens de sucesso ao finalizar
- **Navegação intuitiva**: Botões claros e responsivos

### Gestão Administrativa
- **CRUD completo**: Create, Read, Update, Delete
- **Validações**: Campos obrigatórios e consistência de dados
- **Segurança**: Acesso protegido por login
- **Responsividade**: Interface adaptável a dispositivos móveis

### Relatórios Inteligentes
- **Métricas por setor**: Quantidade e média de avaliações
- **Formatação adequada**: Duas casas decimais nas médias
- **Filtros automáticos**: Apenas setores com avaliações

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Equipe de Desenvolvimento

Este projeto foi desenvolvido por:

- **José Victor** - [GitHub](https://github.com/Zevitu22)
- **Lucas Felipe** - [GitHub](https://github.com/lfsiqueiras)
- **Lucas Samuel** - [GitHub](https://github.com/ManabeJnchr)

---

<p align="center">
Feito com ❤️ para melhorar a qualidade dos serviços de saúde
</p>

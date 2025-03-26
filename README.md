
# 🚦 **Sistema de Multas**

Este projeto é um **sistema de gerenciamento de multas** desenvolvido em Java, com intenção acadêmica, utilizando interfaces gráficas com **Swing**. Ele permite o cadastro de infratores e multas, consulta de multas por infrator e uma área específica para fiscais, onde é possível alterar o status de pagamento das multas.

---

## 🚀 **Funcionalidades Principais**

- **Cadastro de Infratores**: Permite cadastrar infratores com informações como nome, CPF e CNH.
- **Cadastro de Multas**: Permite associar multas a infratores, com detalhes como tipo de infração, data e valor.
- **Consulta de Multas**: Exibe as multas de um infrator de forma organizada, com detalhes como tipo, data, valor e status de pagamento.
- **Área do Fiscal**: Permite ao fiscal pesquisar infratores, visualizar suas multas e alterar o status de pagamento de multas específicas.

---

## 🛠️ **Tecnologias Utilizadas**

- **Java**: Linguagem de programação principal.
- **Swing**: Biblioteca para criação de interfaces gráficas.
- **Git**: Controle de versão do projeto.

---

## 📂 **Estrutura do Projeto**

O projeto é organizado da seguinte forma:

- **Infrator.java**: Classe que representa um infrator.
- **Multa.java**: Classe que representa uma multa.
- **Pagavel.java**: Interface para cálculo do valor da multa.
- **Pessoa.java**: Classe abstrata que define atributos comuns como nome, CPF e CNH.
- **TelaCadastroInfrator.java**: Interface para cadastro de infratores.
- **TelaCadastroMulta.java**: Interface para cadastro de multas.
- **TelaConsultaMultas.java**: Interface para consulta de multas por infrator.
- **TelaFiscal.java**: Interface para a área do fiscal.
- **SistemaMultasGUI.java**: Classe principal que inicia o sistema.

---

## 🖥️ **Como Executar**

1. Clone o repositório:
   ```bash
   git clone https://github.com/SAUL-ALVES/Proj-Sistema-De-Multas.git
   ```
2. Abra o projeto em uma IDE Java (como Eclipse ou IntelliJ).
3. Execute a classe **`SistemaMultasGUI`** para iniciar o sistema.

---

## 🎨 **Exemplo de Uso**

1. **Cadastre um infrator**:
   - Preencha os campos de nome, CPF e CNH (opcional).
2. **Associe multas ao infrator**:
   - Informe o tipo de infração, data e valor da multa.
3. **Consulte as multas**:
   - Na área de consulta ou na área do fiscal, visualize as multas de um infrator.
4. **Altere o status de pagamento**:
   - Na área do fiscal, selecione uma multa e altere seu status para "Pago" ou "Pendente".

---

## 🤝 **Contribuições**

Contribuições são bem-vindas! Sinta-se à vontade para:
- Abrir **issues** para reportar bugs ou sugerir melhorias.
- Enviar **pull requests** com correções ou novas funcionalidades.

---

## 📄 **Licença**

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

### 📧 **Contato**

Se tiver dúvidas ou sugestões, entre em contato:
- **Email**: saulalves55@gmail.com
- **GitHub**: [SAUL-ALVES](https://github.com/SAUL-ALVES)

---



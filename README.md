# Proj Sistema De Multas

Sistema de Multas
Este projeto é um sistema de gerenciamento de multas desenvolvido em Java, utilizando interfaces gráficas com Swing. O sistema permite o cadastro de infratores e multas, consulta de multas por infrator e uma área específica para fiscais, onde é possível alterar o status de pagamento das multas.

Funcionalidades Principais:
Cadastro de Infratores: Permite cadastrar infratores com informações como nome, CPF e CNH.

Cadastro de Multas: Permite associar multas a infratores, com detalhes como tipo de infração, data e valor.

Consulta de Multas: Exibe as multas de um infrator de forma organizada, com detalhes como tipo, data, valor e status de pagamento.

Área do Fiscal: Permite ao fiscal pesquisar infratores, visualizar suas multas e alterar o status de pagamento de multas específicas.

Tecnologias Utilizadas:
Java: Linguagem de programação principal.

Swing: Biblioteca para criação de interfaces gráficas.

Git: Controle de versão do projeto.

Como Executar:
Clone o repositório.

Abra o projeto em uma IDE Java (como Eclipse ou IntelliJ).

Execute a classe SistemaMultasGUI para iniciar o sistema.

Estrutura do Projeto:
Infrator.java: Classe que representa um infrator.

Multa.java: Classe que representa uma multa.

Pagavel.java: Interface para cálculo do valor da multa.

Pessoa.java: Classe abstrata que define atributos comuns como nome, CPF e CNH.

TelaCadastroInfrator.java: Interface para cadastro de infratores.

TelaCadastroMulta.java: Interface para cadastro de multas.

TelaConsultaMultas.java: Interface para consulta de multas por infrator.

TelaFiscal.java: Interface para a área do fiscal.

SistemaMultasGUI.java: Classe principal que inicia o sistema.

Contribuições:
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, correções ou novas funcionalidades.

Exemplo de Uso:
Cadastre um infrator.

Associe multas ao infrator.

Consulte as multas na área de consulta ou na área do fiscal.

Altere o status de pagamento das multas na área do fiscal.


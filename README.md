# 🏦 Sistema Bancário Java

Um sistema de terminal bancário que simula operações financeiras básicas com controle de cheque especial.

## 📋 Funcionalidades

- 🏦 **Gestão de Conta Bancária**
  - Consulta de saldo
  - Depósitos e saques
  - Pagamento de boletos
  - Controle de cheque especial

## 🛠️ Tecnologias

- ![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)
- ![OOP](https://img.shields.io/badge/POO-100%25-blue)

🎯 Regras de Negócio
💳 Cheque Especial
Valor Inicial	Limite do Cheque
≤ R$500,00	R$50,00
> R$500,00	50% do depósito
💰 Juros
20% sobre o valor utilizado do cheque especial

Cobrado no primeiro depósito após a utilização

🖥️ Interface do Sistema
====================================
|      TERMINAL BANCÁRIO JAVA      |
====================================
|  1. Consultar saldo             |
|  2. Consultar cheque especial   |
|  3. Depositar dinheiro          |
|  4. Sacar dinheiro              |
|  5. Pagar um boleto             |
|  6. Verificar uso do cheque     |
|  0. Sair                        |
====================================
📂 Estrutura do Projeto
sistema-bancario/
├── Banco.java         # Lógica principal do sistema
├── Inicial.java       # Interface e menu
└── README.md          # Documentação

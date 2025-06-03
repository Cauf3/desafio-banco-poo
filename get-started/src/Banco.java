public class Banco {
    private double saldoInicial;
    private final double limiteCheque;
    private double valorUsadoCheque; // Rastreia quanto do cheque foi usado

    public Banco(double depositoInicial) {
        this.saldoInicial = depositoInicial;
        // Define o limite do cheque conforme as regras
        this.limiteCheque = depositoInicial <= 500.00 ? 50.00 : depositoInicial * 0.5;
        this.valorUsadoCheque = 0;
    }

    public double getValorCheque() {
        return limiteCheque;
    }

    public double getSaldoTotal() {
        return saldoInicial + (limiteCheque - valorUsadoCheque);
    }

    public boolean isUsandoCheque() {
        return saldoInicial < 0;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("\n====================================");
        System.out.println("|          SALDO DA CONTA          |");
        System.out.println("====================================");
        System.out.printf("|  Saldo disponível: R$ %.2f    |\n", saldoInicial);
        System.out.printf("|  Cheque especial: R$ %.2f    |\n", getValorCheque());
        System.out.println("====================================");
    }

    public void consultarChequeEspecial() {
        System.out.println("\n====================================");
        System.out.println("|        CHEQUE ESPECIAL           |");
        System.out.println("====================================");
        System.out.printf("|  Limite disponível: R$ %.2f   |\n", getValorCheque());
        System.out.println("====================================");
    }

    public void exibirDeposito() {
        System.out.println("\n====================================");
        System.out.println("|         DEPÓSITO                |");
        System.out.println("====================================");
        System.out.printf("|  Saldo atual: R$ %.2f          |\n", getSaldoTotal());
        System.out.println("====================================");
        System.out.print("|  Valor do depósito: R$ ");
    }

    public void depositarDinheiro(double valorDepositado) {
        if (isUsandoCheque()) {
            // Calcula quanto do cheque está sendo usado
            double dividaCheque = Math.abs(saldoInicial);

            // Verifica se o depósito cobre a dívida
            if (valorDepositado >= dividaCheque) {
                // Cobra juros apenas sobre o valor efetivamente usado do cheque
                double juros = dividaCheque * 0.2;
                double valorLiquido = valorDepositado - juros;

                System.out.println("====================================");
                System.out.printf("|  Juros cobrados: R$ %.2f        |\n", juros);
                System.out.printf("|  Valor líquido depositado: R$ %.2f |\n", valorLiquido);
                System.out.println("====================================");

                saldoInicial = valorLiquido - dividaCheque;
                valorUsadoCheque = 0; // Reseta o uso do cheque
            } else {
                // Aplica o depósito diretamente à dívida (sem juros ainda)
                saldoInicial += valorDepositado;
                valorUsadoCheque = Math.abs(saldoInicial);
            }
        } else {
            saldoInicial += valorDepositado;
        }
        System.out.printf("Novo saldo: R$ %.2f\n", saldoInicial >= 0 ? saldoInicial : 0);
        System.out.printf("Limite do cheque disponível: R$ %.2f\n",
                limiteCheque - valorUsadoCheque);
    }

    public void sacarDinheiro(double valorSaque) {
        if (valorSaque <= getSaldoTotal()) {
            saldoInicial -= valorSaque;
            if (saldoInicial < 0) {
                valorUsadoCheque = Math.abs(saldoInicial);
            }
            System.out.println("|  Saque realizado com sucesso!   |");
        } else {
            System.out.println("|  Saldo insuficiente!            |");
        }
        System.out.println("====================================");
    }

    public void exibirSaque() {
        System.out.println("\n====================================");
        System.out.println("|            SAQUE                |");
        System.out.println("====================================");
        System.out.printf("|  Saldo atual: R$ %.2f          |\n", getSaldoTotal());
        System.out.println("====================================");
        System.out.print("|  Valor do saque: R$ ");
    }

    public void exibirPagarBoleto() {
        System.out.println("\n====================================");
        System.out.println("|         PAGAR BOLETO            |");
        System.out.println("====================================");
        System.out.printf("|  Saldo atual: R$ %.2f          |\n", getSaldoTotal());
        System.out.println("====================================");
        System.out.print("|  Código do boleto: R$ ");
    }

    public void pagarUmBoleto(double valorBoleto) {
        if (valorBoleto <= getSaldoTotal()) {
            saldoInicial -= valorBoleto;
            System.out.println("|  Boleto pago com sucesso!       |");
        } else {
            System.out.println("|  Falha no pagamento!            |");
        }
        System.out.println("====================================");
    }

    public static void exibirFinalizacao() {
        System.out.println("\n====================================");
        System.out.println("|      OPERAÇÃO FINALIZADA        |");
        System.out.println("====================================");
        System.out.println("|  Obrigado por utilizar nossos   |");
        System.out.println("|  serviços bancários!            |");
        System.out.println("====================================");
        System.out.println("|  Volte sempre!                  |");
        System.out.println("====================================");
    }

    public void verificarSeChequeUsado() {
        if (valorUsadoCheque > 0) {
            System.out.println("============================================================");
            System.out.printf("|  CHEQUE UTILIZADO: R$ %.2f de R$ %.2f             |\n",
                    valorUsadoCheque, limiteCheque);
            System.out.println("|  JUROS DE 20% SERÃO COBRADOS NO PRÓXIMO DEPÓSITO        |");
            System.out.println("============================================================");
        } else {
            System.out.println("====================================");
            System.out.println("|        CHEQUE NÃO USADO         |");
            System.out.println("====================================");
        }
    }

    private void depositarComJuros(double valorDepositado) {
        double valorUsadoCheque = Math.abs(saldoInicial);
        double juros = valorUsadoCheque * 0.2; // 20% de juros
        double valorLiquido = valorDepositado - juros;

        saldoInicial += valorLiquido;

        System.out.println("====================================");
        System.out.printf("|  Juros cobrados: R$ %.2f        |\n", juros);
        System.out.printf("|  Valor líquido depositado: R$ %.2f |\n", valorLiquido);
        System.out.println("====================================");
    }
}
import java.util.Scanner;

public class Inicial {
    public static void main(String[] args) {
        Banco conta = new Banco(500);
        conta.setSaldoInicial(500);

        // O deposito está cobrando juros infinito após ser usado o cheque especial

        while (true){
            exibirMenu();

            Scanner sc1 = new Scanner(System.in);
            int leitura = sc1.nextInt();

            switch (leitura) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    conta.exibirDeposito();
                    Scanner sc2 = new Scanner(System.in);
                    double deposito = sc2.nextDouble();
                    conta.depositarDinheiro(deposito);
                    break;
                case 4:
                    conta.exibirSaque();
                    Scanner sc3 = new Scanner(System.in);
                    double saque = sc3.nextDouble();
                    conta.sacarDinheiro(saque);
                    break;
                case 5:
                    conta.exibirPagarBoleto();
                    Scanner sc4 = new Scanner(System.in);
                    double boleto = sc4.nextDouble();
                    conta.pagarUmBoleto(boleto);
                    break;
                case 6:
                    conta.verificarSeChequeUsado();
                    break;
                case 0:
                    conta.exibirFinalizacao();
                    return;
                default:
                    System.out.println("Valor Inválido");
            }
        }
        }


    public static void exibirMenu() {
        System.out.println("====================================");
        System.out.println("|      TERMINAL BANCÁRIO JAVA      |");
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|  1. Consultar saldo              |");
        System.out.println("|  2. Consultar cheque especial   |");
        System.out.println("|  3. Depositar dinheiro           |");
        System.out.println("|  4. Sacar dinheiro              |");
        System.out.println("|  5. Pagar um boleto              |");
        System.out.println("|  6. Verificar uso do cheque      |");
        System.out.println("|  0. Sair                         |");
        System.out.println("|                                  |");
        System.out.println("====================================");
        System.out.print("\nDigite a opção desejada: ");
    }

}


import java.util.*; // serve tanto para class random, quando scanner

public class Conta {

    int numero_conta;

    String titular_conta;

    double saldo;


    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial) {
        this.titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000); //gerador de numeros aleaorios(Class RAndom)
    }

    public void VerSaldo() {
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O nome do titular é: " + titular_conta);
        System.out.println("O Saldo da conta é: " + saldo);
    }

    public void Saque(double valor_saque) {
        if (saldo >= valor_saque) {
            this.saldo = saldo - valor_saque;
            System.out.println("Seu novo saldo é: " + saldo);
        } else {
            System.out.println("Saldo Insulficiente");
        }

    }

    public void Deposito(double valor_deposito) {
        if (valor_deposito <= 0) {
            System.out.println("Deposito Invalido");
        } else {
            saldo = saldo + valor_deposito;
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Seu saldo agora é de: " + this.saldo);
        }
    }

    public void Emprestimo(double valor_emprestimo){
        if (valor_emprestimo >= saldo){
            System.out.println("Não e possivel realizar o emprestimo. Saldo menor que o emprestimo:");
        }else{
            saldo = saldo + valor_emprestimo;
            System.out.println("Emprestimo realizado com sucesso");
            System.out.println("Seu saldo agora atualizado é de: "+ this.saldo);
        }
    }

    public void Boleto(double valor_boleto){
        if (valor_boleto >= saldo){
            System.out.println("Saldo Insulficiente para pagamento");
        }else{
            saldo = saldo - valor_boleto;
            System.out.println("Pagamento realizado com sucesso");
            System.out.println("Seu saldo atual é de: " + this.saldo);
        }
    }

    public void Iniciar() {
        int opcao;
        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        } while (opcao != 6);
    }

    public void Exibir_menu(){
        System.out.println("Bem vindos ao meu sistema bancario" + "\0/");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Ver Saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Emprestimo");
        System.out.println("5 - Pagamento");
        System.out.println("6 - Finalizar");
    }

    public void Escolher_funcao(int opcao){
        double saque;
        double deposito;
        double emprestimo;
        double boleto;

        switch (opcao){
            case 1:
                VerSaldo();
                break;
            case 2:
                System.out.println("Digite o valor do Saque: ");
                saque = entrada.nextDouble();
                Saque(saque);
                break;
            case 3:
                System.out.println("Digite o valor a ser depositado");
                deposito = entrada.nextDouble();
                Deposito(deposito);
                break;
            case 4:
                System.out.println("Digite o valor do emprestimo :");
                emprestimo = entrada.nextDouble();
                Emprestimo(emprestimo);
                break;
            case 5:
                System.out.println("Digite o valor do boleto : ");
                boleto = entrada.nextDouble();
                Boleto(boleto);
                break;
            case 6:
                System.out.println("Operação Finalizada, Obrigada por usar nossos serviços");
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }

}

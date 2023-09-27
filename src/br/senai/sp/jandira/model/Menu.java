package br.senai.sp.jandira.model;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Conta referenciaConta = new Conta();
    Cliente referenciaCliente = new Cliente();

    public void executarMenu(){

        boolean continuar = true;

        do {

            System.out.println("/-/-/-/-/-/   Menu  /-/-/-/-/-/");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Gerar Conta");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Realizar Deposito");
            System.out.println("5 - Realizar Saque");
            System.out.println("6 - Transferencia ");
            System.out.println("7 - Sair");
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

            int optionClient = scanner.nextInt();
            scanner.nextLine();

            switch (optionClient) {

                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfPesquisado = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfPesquisado);

                    if (clienteConta != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        referenciaConta.adicionarContaList(conta);
                        System.out.println("Conta criada com sucesso !");
                    } else {
                        System.out.println("Usuario não Cadastrado...");
                    }

                    break;

                case 3:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfConsulta = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaConsulta = referenciaConta.pesquisarConta(cpfConsulta);

                    if (contaConsulta != null){
                        double saldoConta = contaConsulta.getSaldo();
                        System.out.println("O valor disponivel na conta é: " + saldoConta);
                    } else {
                        System.out.println("O usuario informado não possui uma conta...");
                    }

                    break;

                case 4:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe um valor para deposito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.realizarDeposito(valorDeposito);

                    } else {
                        System.out.println("O usuario informado não possui uma conta...");
                    }

                    break;

                case 5:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("Informe um valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.avaliaSaque(valorSaque);
                        contaSaque.realizarSaque(valorSaque);

                    } else {
                        System.out.println("O usuario informado não possui uma conta...");
                    }

                    break;

                case 6:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTransferidor = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaTransferidor = referenciaConta.pesquisarConta(cpfTransferidor);

                    if (contaTransferidor != null) {
                        System.out.println("Informe o CPF da conta pra transferencia: ");
                        long cpfTransferencia = scanner.nextLong();
                        scanner.nextLine();

                        Conta contaTransferencia = referenciaConta.pesquisarConta(cpfTransferencia);

                        if (contaTransferencia != null) {
                            System.out.println("Informe o valor da transferência: ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();

                            contaTransferidor.realizarTransferencia(valorTransferencia, contaTransferencia);
                        } else {
                            System.out.println("O usuario informado não possui uma conta...");
                        }
                    } else {
                        System.out.println("O usuario informado não possui uma conta...");
                    }
                    break;


                case 7:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
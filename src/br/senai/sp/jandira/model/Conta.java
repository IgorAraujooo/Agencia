package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    boolean validaSaldo;
    private int numeroConta;
    private double saldo = 0;
    private String agencia = "000-35-XX";

    private Cliente cliente;

    List<Conta> listConta = new ArrayList<>();

    public void adicionarContaList(Conta conta){
        listConta.add(conta);
    }

    public Conta pesquisarConta(long cpf){
        for (Conta conta: listConta) {
            long validaCpf = conta.cliente.getCpf();
            if (validaCpf == cpf){
                return conta;
            }
        }
        return null;
    }

    public void gerarConta(Cliente cliente){
        numeroConta = (int) (Math.random()*10000);
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarDeposito(Double valor){
        this.saldo += valor;
        System.out.println("O saldo da conta é: " + this.saldo);
    }

    public void realizarSaque(Double valor){

        if (validaSaldo) {
            this.saldo -= valor;
            System.out.println("O saldo da conta é: " + this.saldo);
        } else{
            System.out.println("Você não tem saldo para essa transação");
        }
    }

    public void consultarSaldo(){
        System.out.println("Seu saldo é: " + this.saldo);
    }

    public void avaliaSaque(double valor){
        if (valor > this.saldo){
            validaSaldo = false;
        }else {
            validaSaldo = true;
        }
    }

    public void realizarTransferencia(double valor, Conta contaDestino) {
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor;
            contaDestino.realizarDeposito(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Transferência não foi possível devido a saldo insuficiente ou valor inválido.");
        }
    }


}
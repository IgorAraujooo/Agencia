package br.senai.sp.jandira.model;

public class Conta {

    private int numeroConta = 1234;

    private double saldo = 9652;

    private String agencia = "000-35-xxx";

    public void realizarDeposito(Double valor) {
        this.saldo += valor;
        System.out.println("O Saldo da sua conta é" + this.saldo);
    }

    public void realizarSaque(Double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente. O saldo da sua conta é: " + this.saldo);
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado. O saldo da sua conta é: " + this.saldo);
        }

    }

    public void consultarSaldo() {
        System.out.println("Seu saldo é:  " + this.saldo);
    }


    }
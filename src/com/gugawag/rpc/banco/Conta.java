package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable{


    private static final long serialVersionUID = -2766164110842434637L;
    private String numero;
    private double saldo;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }


    @Override
    public String toString() {
        return "Conta: \n" + "   número = " + numero + "\n" + "   saldo = " + saldo;
    }
}
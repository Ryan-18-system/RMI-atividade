package com.gugawag.rpc.banco;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF, Serializable {

    private static final long serialVersionUID = -612832790853130235L;
    private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
        contas = new ArrayList<>();
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public void adicionarConta(String numeroConta, double saldoInicial) throws RemoteException {
        this.contas.add(new Conta(numeroConta, saldoInicial));
    }

    @Override
    public Conta pesquisarConta(String numeroConta) throws RemoteException {
        return this.contas.stream()
                .filter(x -> Objects.equals(x.getNumero(), numeroConta))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void removerConta(String numeroConta) throws RemoteException {
        this.contas.removeIf(x-> Objects.equals(x.getNumero(), numeroConta));
    }

}

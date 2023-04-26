package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;

public abstract class Conta {

    private Long id;

    private int numero;

    private Agencia agencia;

    private double saldo;

    private Pessoa titular;

    public Conta() {
    }

    public Conta(Long id, int numero, Agencia agencia, double saldo, Pessoa titular) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public Conta setId(Long id) {
        this.id = id;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Conta setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Conta setAgencia(Agencia agencia) {
        this.agencia = agencia;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public Conta setTitular(Pessoa titular) {
        this.titular = titular;
        return this;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numero=" + numero +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}

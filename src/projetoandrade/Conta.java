package projetoandrade;

import java.io.Serializable;

public class Conta implements Serializable{
    private String numeroConta;
    private Cliente cliente;
    private double saldo;
    private double credito;
    private boolean tipo;

    public Conta(String numeroConta, Cliente cliente, double saldo) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.tipo = false;
    }
    
    public Conta(String numeroConta, Cliente Cliente, double saldo, boolean tipo) {
        this.numeroConta = numeroConta;
        this.cliente = Cliente;
        this.saldo = saldo;
        this.tipo = tipo;
        this.credito = 2000;
    }

    public Conta(String numeroConta, Cliente cliente, double saldo, double credito, boolean tipo) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.credito = credito;
        this.tipo = tipo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.cliente = Cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    
    @Override
    public String toString() {
        return "Conta{ " + "Numero: " + numeroConta +", "+ cliente + ", Saldo: " + saldo + " }";
    }
    
}
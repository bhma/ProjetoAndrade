package projetoandrade;

import java.io.Serializable;

public class RegConta implements Serializable{
    private String numeroConta;
    private boolean tipo;
    private String cpf;
    private double saldo;
    private double credito;

    public RegConta(String numeroConta, boolean tipo, String cpf, double saldo, double credito) {
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.cpf = cpf;
        this.saldo = saldo;
        this.credito = credito;
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "RegConta{" + "numeroConta=" + numeroConta + ", tipo=" + tipo + ", cpf=" + cpf + ", saldo=" + saldo + ", credito=" + credito + '}';
    }
}

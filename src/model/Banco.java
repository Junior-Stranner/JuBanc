package model;
public class Banco {
    private String nomeCliente;
    private int numeroConta;
    private String senha;
    private double saldo;
    private double saque;


    public Banco() {
      super();
    }
    

    public Banco(String nomeCliente, int numeroConta, String senha, double saldo, double saque) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
        this.saque = saque;
    
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

  

}
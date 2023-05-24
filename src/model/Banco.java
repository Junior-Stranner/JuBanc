package model;
public class Banco {
    private String nomeCliente;
    private int numeroConta;
    private String senha;
    private double saldo;
    private double saque;
    private String tipoConta;

    public Banco() {
      super();
    }
    

    public Banco(String nomeCliente, int numeroConta, String senha, double saldo, double saque, String tipoConta) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
        this.saque = saque;
        this.tipoConta = tipoConta;
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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

}
package model;
public class Cliente {
    private int id;
    private String nomeCompleto;
    private String senha;
    private String tipoConta;

    
    public Cliente() {
     super();
    }
    public Cliente(int id, String nomeCompleto, String senha,String tipoConta) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}

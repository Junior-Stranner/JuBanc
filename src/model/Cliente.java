package model;
public class Cliente {
    private int id;
    private String nomeCompleto;
    private String senha;
    
    public Cliente() {
     super();
    }
    public Cliente(int id, String nomeCompleto, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
    
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

}

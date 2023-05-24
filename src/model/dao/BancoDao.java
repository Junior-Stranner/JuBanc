package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.Cliente;

public class BancoDao {

    public static void salvarDadosBD(Banco banco) throws SQLException{
        String sql =  "INSERT INTO banco (nomecliente,numeroconta,saldo,saque,tipoconta,senha) VALUES (?,?)";

        Connection con = null;
        PreparedStatement codigo = null;

        try {

            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql);

            codigo.setString(1,banco.getNomeCliente());
            codigo.setInt(2,banco.getNumeroConta());
            codigo.setDouble(3,banco.getSaldo());
            codigo.setDouble(4,banco.getSaque());
            codigo.setString(5,banco.getTipoConta());
            codigo.setString(1,banco.getSenha());

            codigo.execute();
            
        } catch (SQLException x) {
            // TODO: handle exception
            System.out.println("ERro de conexão com Banco ...");
            x.getStackTrace();
        }finally{

          if(codigo != null){
            codigo.close();
          }
          if(con != null)
             con.close();
          

        }
    }
    
    public static ArrayList<Banco> mostrarBancoBD() throws SQLException{
        String sql =  "SELECT * from Banco";

		ArrayList<Banco> bancos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
      //  ClienteDao clienteDao = new ClienteDao();

		Connection con = null;
		PreparedStatement codigo = null;
	    ResultSet dadosBD = null;

        Banco banco = new Banco();
        Cliente cliente = new Cliente();
        banco.setNumeroConta(cliente.getId());
        banco.setNomeCliente(cliente.getNomeCompleto());
        banco.setSenha(cliente.getSenha());

    try {
        con = Conexao.conectarBD();
		codigo = con.prepareStatement(sql);
		dadosBD = codigo.executeQuery();


        while(dadosBD.next()){
           codigo.setInt(1,banco.getNumeroConta());
           codigo.setString(2, banco.getNomeCliente());
           codigo.setString(3,banco.getSenha());
           codigo.setDouble(4, banco.getSaldo());
           codigo.setDouble(5, banco.getSaque());
           codigo.setString(6, banco.getTipoConta());

        }
        
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("Erro...");
    }finally{
        if(con != null){
            con.close();
        }
        if(codigo != null);
           codigo.close();
    }
    return bancos;

    }
    public void salvarDadosBD(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO cliente (id, nomeCompleto , senha) VALUES (?,?)";
    
        Connection con = null;
        PreparedStatement codigo = null;
    
        try {
            con = Conexao.conectarBD(); 
    
            codigo = con.prepareStatement(sql);
    
            codigo.setInt(1, cliente.getId());
            codigo.setString(2, cliente.getNomeCompleto());
            codigo.setString(3, cliente.getSenha());
    
            codigo.execute();
    
        }catch(SQLException s) {
            System.out.println("ERRO....");
            s.printStackTrace();
        }finally {
            if (codigo != null) {
                codigo.close();
            }
            if (con != null)
                con.close();
        }
    
    }
    
    
    public ArrayList<Cliente> lerDadosBD() throws SQLException{
        String sql =  "SELECT * from cliente";
    
        ArrayList<Cliente> clientes = new ArrayList<>();
    
        Connection con = null;
        PreparedStatement codigo = null;
        ResultSet dadosBD = null;
    
        try {
            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql);
            dadosBD = codigo.executeQuery();
    
            while (dadosBD.next()) {
                Cliente cliente = new Cliente();
                codigo.setInt(1, cliente.getId());
                codigo.setString(2, cliente.getNomeCompleto());
                codigo.setString(3, cliente.getSenha());
    
                clientes.add(cliente);
            }
        }catch (Exception e) {
            System.out.println("ERRO.....");
        }finally {
            if (codigo != null) {
                codigo.close();
            }
            if (con != null)
                con.close();
        }
        return clientes;
    }
    
    
    public void alterarContatoBD(Cliente cliente) throws SQLException {
            
        String sql1 =  "UPDATE cliente SET senha = ? WHERE nomeCompleto = ?";
    
        Connection con = null;
        PreparedStatement codigo = null;
    
        try {
            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql1);
            codigo.setString(1, cliente.getNomeCompleto());
            codigo.setString(2,cliente.getSenha());
            
        } catch (SQLException e) {
            System.out.println("ERRO UPDATE.....");
                e.printStackTrace();
            // TODO: handle exception
        }finally{
    
            if(codigo != null){
                codigo.close();
            }
            if(con != null)
                con.close();
            }
        }
    
    
    
    public Cliente pesquisarContaBD(String nome) throws SQLException{
        String sql =  "SELECT * FROM cliente WHERE id = ? ";
    
        Cliente cliente = null;
        Connection con = null;
        PreparedStatement codigo = null;
        ResultSet dadosBD = null;
    
        try {
            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql);
            codigo.setInt(1,cliente.getId());
            dadosBD = codigo.executeQuery();			
    
    
            if (dadosBD.next() != false) {
                cliente = new Cliente();
                codigo.setInt(1, cliente.getId());
                codigo.setString(2, cliente.getNomeCompleto());
                codigo.setString(3, cliente.getSenha());
            } 
            
    
        }
        catch (Exception e) {
            System.out.println("ERRO.....");
        }finally {
            if (codigo != null) {
                codigo.close();
            }
            if (con != null)
                con.close();
        }
        return cliente;
    }
    
    
    public void deletarContaBD(Cliente clientes) throws SQLException {
        
        String sql1 =  "DELETE FROM cliente WHERE id = ?";
    
        Cliente cliente = null;
        Connection con = null;
        PreparedStatement codigo = null;
    
        try {
            con = Conexao.conectarBD();
            codigo = con.prepareStatement(sql1);
            codigo.setInt(1, cliente.getId());
            codigo.execute();			
        }
        catch (SQLException e) {
            System.out.println("ERRO DELETE.....");
            e.printStackTrace();
        }finally {
            if (codigo != null) {
                codigo.close();
            }
            if (con != null)
                con.close();
        }		
    }
}

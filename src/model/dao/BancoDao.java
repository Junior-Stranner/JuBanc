package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.Cliente;

public class BancoDao {
    
    private static void lerDadosBD() throws SQLException{
        String sql =  "SELECT * from Banco";

		ArrayList<Banco> bancos = new ArrayList<>();
        ArrayList<Cliente> cliente = new ArrayList<>();
      //  ClienteDao clienteDao = new ClienteDao();

		Connection con = null;
		PreparedStatement codigo = null;
	    ResultSet dadosBD = null;

    try {
        con = Conexao.conectarBD();
		codigo = con.prepareStatement(sql);
		dadosBD = codigo.executeQuery();

        while(dadosBD.next()){
           Banco banco = new Banco();
           codigo.setInt(1,banco.getNumeroConta());
           codigo.setString(2, banco.getNomeCliente());
           codigo.setDouble(3, banco.getSaldo());
           codigo.setDouble(4, banco.getSaque());
           codigo.setString(5, banco.getTipoConta());

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

    }
}

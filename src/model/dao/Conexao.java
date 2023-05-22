package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static String url = "jdbc:postgresql://localhost:5432/AgendaContatos"; //Nome da base de dados
	private static String user = "Banco Ju"; //nome do usu�rio do postgres
	private static String password = "123"; //senha do postgres

	public static Connection conectarBD() {
		try{
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		}catch(SQLException sqlErro) {
			System.out.println("ERRO: Conex�o");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("ERRO: Driver conex�o");
			return null;
		}
	}	
}


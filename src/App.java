import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Banco;
import model.Cliente;
import model.dao.ClienteDao;

public class App {
    private static ClienteDao clienteDao = new ClienteDao();
    public static void main(String[] args){
        int op = 0;

        do{
            System.out.println("Banco Ju"
            +"\n 1 - Cadastrar Cliente no Banco"
            +"\n 2 - mostrar Clientes Cadastrados"
            +"\n 3 - ");
            switch(op){

                case 1: try {
                    clienteDao.salvarDadosBD(lerDadosCliente());
                } catch (SQLException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
               break;

               case 2: 
            }
        }while(op != 0);
    }

    private static Cliente lerDadosCliente(){
        Scanner in = new Scanner(System.in);
        ArrayList <Cliente> clientes = new ArrayList<>();
		Cliente clienteNovo = new Cliente();

        int id = clientes.size()+ 1; 
        System.out.println("Seu id de Cadastro" +id);
        id = Integer.parseInt(in.nextLine());

        System.out.println("Digite o seu Nome Completo");
        String nomeCompleto = in.nextLine();

        System.out.println("Digite a sua Senha");
        String senha = in.nextLine();

        clienteNovo.setId(id);
        clienteNovo.setNomeCompleto(nomeCompleto);
        clienteNovo.setSenha(senha);

       return clienteNovo;
    }

    private static void mostraContaBanco(ArrayList<Banco>bancos){
        Banco banco;
        
        for(int i = 0; i< bancos.size();i++){
            banco = bancos.get(i);
        }
    }
}

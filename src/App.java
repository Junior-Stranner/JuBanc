import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Banco;
import model.dao.BancoDao;

public class App {
    private static BancoDao bancoDao = new BancoDao();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int op = 0;

        do{ 
            System.out.println("Banco Ju"
            +"\n 1 - Cadastrar no Banco"
            +"\n 2 - mostrar Conta do Cliente"
            +"\n 3 - ");
            op = Integer.parseInt(in.nextLine());
            try {
            switch(op){
               
                case 1:bancoDao.salvarDadosBD(lerDadosCliente());
               
               break;

               case 2:ArrayList<Banco> bancos = new ArrayList<>();
                      bancos = BancoDao.mostrarBancoBD();
                mostraContaCliente(bancos); break;

          
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        }while(op != 9);
  
    }

    private static Banco lerDadosCliente(){
        Scanner in = new Scanner(System.in);
        ArrayList <Banco> bancos = new ArrayList<>();
		Banco clienteNovo = new Banco();
        double saldo = 0;
        double saque = 0;


        int numeroBanco = bancos.size()+ 1; 
        System.out.println("Seu id de Cadastro : " +numeroBanco);
     //   id = Integer.parseInt(in.nextLine());

        System.out.println("Digite o seu Nome Completo");
        String nomeCliente = in.nextLine();

        System.out.println("Digite a sua Senha");
        String senha = in.nextLine();

        System.out.println("Tipo de Conta : ");
        String tipoConta = in.nextLine();


       clienteNovo.setNumeroConta(numeroBanco);
       clienteNovo.setNomeCliente(nomeCliente);
       clienteNovo.setSenha(senha);
       clienteNovo.setSaldo(saldo);
       clienteNovo.setSaque(saque);
       clienteNovo.setTipoConta(tipoConta);
        

       return clienteNovo;
    }

    private static void mostraContaCliente(ArrayList<Banco>bancos){
        Banco banco;
        
        for(int i = 0; i< bancos.size();i++){
            banco = bancos.get(i);

            System.out.println("\n Numero da Conta : " +banco.getNumeroConta()
            +"\n Nome do Cliente : "+banco.getNomeCliente()
            +"\n tipo de Conta do Cliente : "+banco.getTipoConta()
            +"\n Saldo : "+banco.getSaldo()
            +"\n Saque : "+banco.getSaque());
        }
    }
}

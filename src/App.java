import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Banco;
import model.Cliente;

public class App {
    static Scanner in = new Scanner(System.in);   
    public static void main(String[] args){
      
        ArrayList <Cliente> clientes = new ArrayList<>();
        ArrayList<Banco>bancos=new ArrayList<>();

        int op = 0;

        do{ 
            System.out.println("Banco Ju"
            +"\n 1 - Cadastrar Cliente"
            +"\n 2 - mostrar Conta do Cliente"
            +"\n 3 - Fazer Depósito");
            op = Integer.parseInt(in.nextLine());
           
            switch(op){
               
                case 1:cadastrarClienteBanco(clientes,bancos);break;
                case 2:mostraContaCliente(bancos,clientes);break;
                case 3:depositarValor(bancos);break;
            }
     
        }while(op != 9);
  
    }

    private static void depositarValor( ArrayList<Banco>bancos) {

        System.out.print("Digite o valor que queira Depositar :");
        double valor = Double.parseDouble(in.nextLine());

        for (Banco banco : bancos) {
            banco.setSaldo(banco.getSaldo()+valor);
        }
    }

    private static void cadastrarClienteBanco ( ArrayList <Cliente> clientes, ArrayList<Banco>bancos){
        Scanner in = new Scanner(System.in);
       
        int id = clientes.size()+ 1; 
        System.out.print("\nSeu id de Cadastro : " +id);
     //   id = Integer.parseInt(in.nextLine());

        System.out.print("\n Digite o seu Nome Completo : ");
        String nomeCompleto = in.nextLine();

        System.out.print("Digite a sua Senha : ");
        String senha = in.nextLine();

        System.out.print("Tipo de Conta : ");
        String tipoConta = in.nextLine();

        Cliente cliente = new Cliente(id,nomeCompleto,senha,tipoConta);
        clientes.add(cliente);

        System.out.println("\n====================================\n"
        +"Conta Criada de "+cliente.getNomeCompleto()
        +"\n====================================\n");

        System.out.println("Conta do Banco Criada "
        +"\n Seus Dados da Conta ");

        String nomeCliente = cliente.getNomeCompleto() ;
        int numeroConta = cliente.getId();
        String senhaBanco =cliente.getSenha();
       double saldo = 0;
       double saque = 0;

       Banco banco = new Banco(nomeCliente,numeroConta,senhaBanco,saldo,saque); 
       bancos.add(banco);

    }

    private static void mostraContaCliente( ArrayList<Banco>bancos, ArrayList <Cliente> clientes){
       

      for (Banco banco : bancos) {
        for (Cliente cliente : clientes) {
        
            System.out.println("\n Numero da Conta : " +banco.getNumeroConta()
            +"\n Nome do Cliente : "+banco.getNomeCliente()
            +"\n Senha do Banco  : "+banco.getSenha()
            +"\n tipo de Conta do Cliente : "+cliente.getTipoConta()
            +"\n Saldo : "+banco.getSaldo()
            +"\n Saque : "+banco.getSaque());
    
        }
    }
    }
}

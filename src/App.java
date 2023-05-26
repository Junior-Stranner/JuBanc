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
    //    ArrayList<Banco> nvsBancos = new ArrayList<>();

        int op = 0;

        do{ 
            System.out.println("Banco Ju"
            +"\n 1 - Cadastrar Cliente"
            +"\n 2 - mostrar Dados da Conta"
            +"\n 3 - Fazer Depósito"
            +"\n 4 - Fazer saque "
            +"\n 5 - Realizar Tranferencia Bancária"
            +"\n 6 - Histórico da Conta");
            op = Integer.parseInt(in.nextLine());
           
            switch(op){
               
                case 1:cadastrarClienteBanco(clientes,bancos);break;
                case 2:mostraContaCliente(bancos,clientes);break;
                case 3:depositarValor(bancos);break;
                case 4:sacarDinheiro(bancos);break;
                case 5:transferenciaBancaria(bancos);break;
                case 6:historicoConta(bancos,clientes);break;
            }
     
        }while(op != 9);
  
    }

    private static void historicoConta(ArrayList<Banco> bancos,ArrayList<Cliente>clientes) {

        System.out.println("Digite a sua Senha ");
        String senha = in.nextLine();

        for (Banco banco : bancos) {
            if(banco.getSenha().equalsIgnoreCase(senha)){

                System.out.println("\n============================================="
                +"\nSua Conta foi encontrada "+banco.getNomeCliente()
                +"\n=============================================");

                System.out.println("\n Numero da Conta : " +banco.getNumeroConta()
            +"\n Nome do Cliente : "+banco.getNomeCliente()
            +"\n Histórico Saldo Atual: "+banco.getSaldo()
            +"\n Histórico Saque : "+banco.getSaque()
            +"\n Status da Conta : "+banco.isStatus());
            }else{
                System.out.println("Conta inexistente...");
            }
              
        }
    }

    private static void transferenciaBancaria(ArrayList<Banco>bancos) {
        System.out.println("Digite o id da Conta para Transferencia");
        int idOutraConta = Integer.parseInt(in.nextLine());

        for (Banco banco : bancos) {

            if(banco.getNumeroConta() == idOutraConta){
                System.out.println("\n Conta Existente!!");
                  if(banco.isStatus()==true){
                    System.out.println("\n Conta Encontrada !!");
                  }
            }
            System.out.println("\n Conta de "+banco.getNomeCliente()
            +"\n Digite o valor que deseja Tranferir ");
            double tranferirValor = Double.parseDouble(in.nextLine());

            if(banco.getSaldo()>tranferirValor){
                banco.setSaldo(banco.getSaldo() - tranferirValor);
          }else{
              System.out.println("Erro de Saque , saldo insuficiente");break;
          }

         System.out.println("\n Saldo Atual : "+banco.getSaldo()
          +"\n Valor que foi Sacado  : "+tranferirValor);
          banco.setSaque(banco.getSaque()- tranferirValor);

    }
}

    private static void sacarDinheiro(ArrayList<Banco>bancos) {
         System.out.println("Digite o Valor que deseja Sacar");
         double valorSaque = Double.parseDouble(in.nextLine());
         for (Banco banco : bancos) {
            
            if(banco.getSaldo()>valorSaque){
                  banco.setSaldo(banco.getSaldo() - valorSaque);
            }else{
                System.out.println("Erro de Saque , saldo insuficiente");break;
            }

           System.out.println("\n Saldo Atual : "+banco.getSaldo()
            +"\n Valor que foi Sacado  : "+valorSaque);
            banco.setSaque(banco.getSaque()- valorSaque);
         } 

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
       boolean status = false;


       Banco banco = new Banco(nomeCliente,numeroConta,senhaBanco,saldo,saque,status); 
       if(banco.getNumeroConta() == id){
        banco.setStatus(true);
       }
       bancos.add(banco);

    }

    private static void mostraContaCliente( ArrayList<Banco>bancos, ArrayList <Cliente> clientes){
       
      for (Banco banco : bancos) {
        for (Cliente cliente : clientes) {

            System.out.println("\n Numero da Conta : " +banco.getNumeroConta()
            +"\n Nome do Cliente : "+banco.getNomeCliente()
            +"\n Senha do Banco  : "+banco.getSenha()
            +"\n tipo de Conta do Cliente : "+cliente.getTipoConta()
            +"\n Saldo Atual: "+banco.getSaldo()
            +"\n Sque : "+banco.getSaque()
            +"\n Status da Conta : "+banco.isStatus());
            
        }
    }
    }
}

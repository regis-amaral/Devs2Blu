package Views;

import java.util.Scanner;

import Controllers.ClienteController;
import Models.Cliente;

public class CadastroCliente extends View {

    private static Scanner scanner;

    public static void menu(){
        System.out.println(VERDE + "Selecione a opção desejada:\n" +
        "1 - Cadastrar Cliente\n" +
        "2 - Alterar Cliente\n" +
        "3 - Listar Clientes\n" + RESET);
        scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        switch(opcao){
            case "1" : cadastrar(); break;
            case "2" : ; break;
            default : System.out.println("Opção inválida!");
        }
    }

    private static void cadastrar(){
        ClienteController clienteControler = new ClienteController();
        
        try{
            System.out.println("Informe o nome:");
            String nome = scanner.nextLine();
            System.out.println("Informe o telefone:");
            String telefone = scanner.nextLine();
            System.out.println("Informe o CPF:");
            String cpf = scanner.nextLine();
            Cliente cliente = new Cliente(nome, telefone, cpf);


        }catch(Exception e){
            System.out.println("Dado informado inválido!\nCadastro não finalizado...");
        }

    }
}

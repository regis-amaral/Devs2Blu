import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HelloWorld{
    private static String nome;

    public static void main(String[] args){
        nome = recebeNome();
        imprimeNome();
        imprimeNomeInvertido();
        contaLetrasDistintas();
    }

    public static String recebeNome(){
        Scanner input = new Scanner(System.in);
        String nome = "";
        while (nome.trim().isEmpty()) {
            System.out.print("Qual o seu nome? ");
            nome = input.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("Por favor, digite um nome válido.");
            }
        }
        return nome;
    }

    public static void imprimeNome(){
        System.out.println("Olá, " + nome + "!");
    }

    public static void imprimeNomeInvertido(){
        String nomeInvertido = "";
        for (int i = nome.length() - 1; i >= 0; i--) {
            nomeInvertido += nome.charAt(i);
        }
        System.out.println("Seu nome invertido é " + nomeInvertido);
    }

    public static void contaLetrasDistintas() {
        Set<Character> letrasDistintas = new HashSet<Character>();
        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);
            if (Character.isLetter(c)) {
                letrasDistintas.add(Character.toLowerCase(c));
            }
        }
        System.out.println("Seu nome tem " + letrasDistintas.size() + " letras distintas.");
    }
}
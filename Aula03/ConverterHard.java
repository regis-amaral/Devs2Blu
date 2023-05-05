package Aula03;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterHard {

    public static void main(String[] args) {
        intToDouble();
        stringToInteger();
        stringToBoolean();
        decimalToInteger();
        charToInteger();
    }

    /**
     * Escreva um programa que leia um número inteiro da entrada do usuário e o converta em um objeto da classe wrapper Double.
     * Em seguida, exiba na tela o valor da conversão.
     */
    private static void intToDouble(){
        System.out.println("PARTE 1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        try {
            int numInt = scanner.nextInt();
            Double numDouble = Double.valueOf(numInt);
            System.out.println("O número em formato Double é: " + numDouble);
        }catch (InputMismatchException e){
            System.out.println("Você não digitou um número válido!");
        }

    }

    /**
     * Escreva um programa que leia uma string da entrada do usuário e tente convertê-la para um objeto da classe wrapper Integer.
     * Caso a conversão seja bem-sucedida, multiplique o valor por 2 e exiba na tela. Caso contrário, exiba uma mensagem de erro.
     */
    private static void stringToInteger(){
        System.out.println("\nPARTE 2");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String str = scanner.nextLine();

        try {
            Integer numInt = Integer.parseInt(str);
            int resultado = numInt * 2;
            System.out.println("O resultado da multiplicação por 2 é: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Erro: A string " + str + " não pode ser convertida para Integer");
        }
    }

    /**
     * Escreva um programa que leia uma string da entrada do usuário e tente convertê-la para um objeto da classe wrapper Boolean.
     * Em seguida, exiba na tela o valor da conversão.
     */
    private static void stringToBoolean(){
        System.out.println("\nPARTE 3");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um valor booleano (true ou false): ");
        String str = scanner.nextLine();
        Boolean bool = Boolean.parseBoolean(str);
        System.out.println("O valor convertido é: " + bool);
    }

    /**
     * Escreva um programa que leia um número decimal da entrada do usuário e o converta em um objeto da classe wrapper Integer.
     * Caso a conversão seja bem-sucedida, exiba na tela o valor da conversão. Caso contrário, exiba uma mensagem de erro.
     */
    private static void decimalToInteger(){
        System.out.println("\nPARTE 4");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número decimal: ");
        try {
            String str = scanner.nextLine();
            double doub = Double.parseDouble(str);
            Integer numInt =  Integer.valueOf((int) doub);
            System.out.println("O número inteiro é: " + numInt);
        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada inválida.");
        }
    }

    /**
     * Escreva um programa que leia um caractere da entrada do usuário e o converta em um objeto da classe wrapper Integer.
     * Em seguida, exiba na tela o valor da conversão em hexadecimal.
     */
    private static void charToInteger(){
        System.out.println("\nPARTE 5");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um caractere: ");
        String str = scanner.nextLine();
        if (str.length() == 1) {
            char c = str.charAt(0);
            Integer numInteger = (int) c;
            System.out.println("O valor em hexadecimal é: " + Integer.toHexString(numInteger));
        } else {
            System.out.println("Erro: entrada inválida.");
        }
    }
}

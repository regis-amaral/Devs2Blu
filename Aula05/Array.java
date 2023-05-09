package Aula05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Array {
    private static Scanner scanner;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        scanner = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println("#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Exibe o terceiro elemento de um array de inteiros com 5 números aleatórios");
            System.out.println("2 - Imprime a primeira letra da segunda palavra de um array com 3 strings");
            System.out.println("3 - Imprime os números pares em um array de inteiros aleatórios com 10 posições");
            System.out.println("4 - Média aritmética de um array com 6 números inteiros aleatórios");
            System.out.println("5 - Calcula a soma de todos os 4 elementos de um array de numeros reais");
            System.out.println("6 - Cria um array de inteiros com 5 entradas do usuário e imprime o maior entre eles");
            System.out.println("7 - Imprime todas as vogais encontradas no texto fornecido pelo usuário");
            System.out.println("x - Sair");
            System.out.println("#########################################");
            String opcao = scanner.nextLine().replaceAll("\\s+", " ").trim();
            switch (opcao) {
                case "1": questaoUm(); break;
                case "2": questaoDois(); break;
                case "3": questaoTres(); break;
                case "4": questaoQuatro(); break;
                case "5": questaoCinco(); break;
                case "6": questaoSeis(); break;
                case "7": questaoSete(); break;
                case "x": exec = false; continue;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void questaoUm(){
        int[] numeros = new Random().ints(5, 1, 100).toArray();
        System.out.println(Arrays.toString(numeros));
        System.out.println("O terceiro elemento do array de inteiros é " + numeros[2]);
    }

    private static void questaoDois(){
        String[] listaPalavras = {"banana", "abacaxi", "laranja"};
        System.out.println(Arrays.toString(listaPalavras));
        System.out.println("A primeira letra da segunda string é: " + listaPalavras[1].charAt(0));
    }

    private static void questaoTres(){
        int[] numeros = new Random().ints(10, 1, 100).toArray();
        System.out.println(Arrays.toString(numeros));
        System.out.print("Números pares no array: ");
        for(int i : numeros){
            if(i % 2 == 0)
                System.out.print(" " + i);
        }
    }

    private static void questaoQuatro(){
        int[] numeros = new Random().ints(6, 1, 100).toArray();
        int total = Arrays.stream(numeros).sum();
        System.out.println(Arrays.toString(numeros));
        System.out.println("A média aritmética do array é  " + total / numeros.length);
    }

    private static void questaoCinco(){
        double[] numeros = new Random().doubles(4, -100, 100).toArray();
        double total = Arrays.stream(numeros).sum();
        System.out.println(Arrays.toString(numeros));
        System.out.println("A soma dos elementos é " + total);
    }

    private static void questaoSeis(){
        int[] numeros = new int[5];
        try{
            for (int i = 0; i < numeros.length; i++){
                System.out.println("Digite um valor para a posição " + (i + 1));
                numeros[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(numeros));
            Arrays.sort(numeros);
            System.out.println("O maior número é " + numeros[numeros.length-1]);
        }catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoSete(){
        System.out.println("Insira um texto:");
        String frase = scanner.nextLine();
        String vogais = frase.toLowerCase().replaceAll("\\s+", "").trim()
                .replaceAll("[^áàâãäéèêëíìîïóòôõöúùûüaeiou]", "");
        System.out.printf("O texto possui %d vogais", vogais.length());
    }

    private static void questaoOito(){

    }

    private static void questaoNove(){

    }

    private static void questaoDez(){
        double[] numeros = new double[5];
        try{
            for (int i = 0; i < numeros.length; i++){
                System.out.println("Digite um valor para a posição " + (i + 1));
                numeros[i] = scanner.nextDouble();
            }
            System.out.println(Arrays.toString(numeros));
            Arrays.sort(numeros);
            System.out.println("O maior número é " + numeros[numeros.length-1]);
        }catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

}

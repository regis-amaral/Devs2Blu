package Aula03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculos {

    public static void main(String[] args) {
       boolean exec = true;
       while(exec){
           System.out.println("\n\n#########################################");
           System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
           System.out.println("1 - Testar cálculos básicos");
           System.out.println("2 - Testar Par / Ímpar");
           System.out.println("3 - Testar Maioridade");
           System.out.println("4 - Testar Comparação de duas Strings");
           System.out.println("5 - Testar média de aluno > 7");
           System.out.println("6 - Calcular a área de um círculo");
           System.out.println("7 - Calcular a soma dos dígitos de um inteiro com 3 dígitos");
           System.out.println("8 - Calcular se um número é primo ou não");
           System.out.println("9 - Verificar sequência aritmética e encontrar a razão entre 3 números");
           System.out.println("10 - Verifica se a frase ou palavra é um palímdromo");
           System.out.println("x - sair");
           System.out.println("#########################################\n");
           Scanner scanner = new Scanner(System.in);
           switch(scanner.nextLine()){
               case "1" : questaoUm(); break;
               case "2" : questaoDois(); break;
               case "3" : questaoTres(); break;
               case "4" : questaoQuatro(); break;
               case "5" : questaoCinco(); break;
               case "6" : questaoSeis(); break;
               case "7" : questaoSete(); break;
               case "8" : questaoOito(); break;
               case "9" : questaoNove(); break;
               case "10" : questaoDez(); break;
               case "x" : exec=false; continue;
           }
           System.out.println("\nPressione Enter para continuar...");
           scanner.nextLine();
       }
    }

    /**
     * Escreva um programa que leia dois números inteiros e exiba o resultado da soma, subtração,
     * multiplicação, divisão e resto da divisão dos dois números.
     */
    private static void questaoUm(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o primeiro número: ");
            int numIntA = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int numIntB = scanner.nextInt();
            System.out.printf("Você digitou os números %d e %d \n", numIntA, numIntB);
            System.out.println("O resultado da soma dos dois números é: " + (numIntA + numIntB));
            System.out.println("O resultado da subtração dos dois números é: " + (numIntA - numIntB));
            System.out.println("O resultado da multiplicação dos dois números é: " + (numIntA * numIntB));
            System.out.println("O resultado da divisão dos dois números é: " + ((double) numIntA / numIntB));
            System.out.println("O resto da divisão dos dois números é: " +  ((double) numIntA % (double) numIntB));
        }catch (InputMismatchException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que verifique se um número é par ou ímpar utilizando o operador módulo.
     */
    private static void questaoDois(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        try {
            int numero = scanner.nextInt();
            if (numero % 2 == 0) {
                System.out.println(numero + " é par.");
            } else {
                System.out.println(numero + " é ímpar.");
            }
        }catch (InputMismatchException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que leia a idade de uma pessoa e verifique se ela é maior ou igual a 18 anos
     * utilizando o operador relacional de maior ou igual.
     */
    private static void questaoTres(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe sua idade: ");
        try {
            int idade = scanner.nextInt();
            if (idade >= 18 && idade <= 122) {
                System.out.println("Você é maior de idade.");
            } else if (idade >= 0 && idade < 18) {
                System.out.println("Você é menor de idade.");
            } else if (idade < 0){
                throw new InputMismatchException();
            }else{
                System.out.println("Ou você ta exagerando ou é o mais novo recordista do Guinness Book!");
            }
        }catch (InputMismatchException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que leia duas strings e verifique se elas são iguais utilizando o operador lógico de igualdade.
     */
    private static void questaoQuatro(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string qualquer: ");
        String strA = scanner.nextLine();
        System.out.print("Digite outra string qualquer: ");
        String strB = scanner.nextLine();
        if(strA.equals(strB)){
            System.out.println("As duas strings digitadas são iguais");
        }else{
            System.out.println("Você digitou duas strings diferentes");
        }
    }

    /**
     * Escreva um programa que calcule a média de três notas e verifique se o aluno foi aprovado ou reprovado
     * utilizando o operador lógico de comparação. Considere que a média para aprovação é 7.0.
     */
    private static void questaoCinco(){
        Scanner scanner = new Scanner(System.in);
        try {
            while(true){
                System.out.println("Digite a nota da primeira avaliação (0.0 a 10): ");
                float nota1 = Float.parseFloat(scanner.nextLine());
                System.out.println("Digite a nota da segunda avaliação (0.0 a 10): ");
                float nota2 = Float.parseFloat(scanner.nextLine());
                System.out.println("Digite a nota da terceira avaliação (0.0 a 10): ");
                float nota3 = Float.parseFloat(scanner.nextLine());
                if(nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10){
                    System.out.println("Você precisa digitar uma nota entre 0.0 e 10");
                    System.out.println("Vamos tentar de novo!\n");
                    continue;
                }
                float total = nota1 + nota2 + nota3;
                float media = total / 3;
                if(media >= 7.0){
                    System.out.println("O aluno está aprovado!");
                }else{
                    System.out.println("O aluno reprovou!");
                }
                break;
            }
        }catch (NumberFormatException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que calcule a área de um círculo, dado o seu raio. Utilize a fórmula A = π * r^2 e o valor de π como 3.14.
     */
    private static void questaoSeis() {
        final double PI = 3.14F;
        double raio, area;        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do raio: ");
        raio = scanner.nextDouble();

        area = PI * Math.pow(raio, 2);
        
        System.out.println("A área do círculo é: " + area);
    }

    /**
     * Escreva um programa que leia um número inteiro de três dígitos e exiba a soma dos seus dígitos.
     */
    private static void questaoSete() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Digite um numero entre 100 e 999:");
        //eu poderia receber o numero inteiro aqui mas eu teria que converter ele para String logo em seguida
        String numero = scanner.nextLine();
        if(numero.length() == 3){
            int digito1 = Integer.parseInt(Character.toString(numero.charAt(0)));
            int digito2 = Integer.parseInt(Character.toString(numero.charAt(1)));
            int digito3 = Integer.parseInt(Character.toString(numero.charAt(2)));
            int soma = digito1 + digito2 + digito3;
            System.out.println("A soma dos três digitos do número é " + soma);
        }else{
            System.out.println("Você inseriu uma entrada inválida!");
        }
    }

    /**
     * Escreva um programa que verifique se um número é primo ou não.
     * Utilize o operador de resto da divisão para verificar se o número é divisível por algum outro número além de 1 e ele mesmo.
     */

     private static void questaoOito() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número inteiro: ");
        int numero = scanner.nextInt();
        boolean t = true;
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                t = false;
        }
        System.out.println(t ? "É primo!" : "Não é primo!");
    }
    /**
     * Escreva um programa que leia três números inteiros e verifique se eles formam uma sequência aritmética.
     * Caso afirmativo, exiba a razão da sequência.
     */
        private static void questaoNove() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite três números inteiros:");
            System.out.print("Número 1: ");
            int num1 = scanner.nextInt();
            System.out.print("Número 2: ");
            int num2 = scanner.nextInt();
            System.out.print("Número 3: ");
            int num3 = scanner.nextInt();

            //verifica se é uma sequencia aritmética, ou seja a razão entre os três números é igual
            boolean sequenciaAritmetica = (num2 - num1) == (num3 - num2);


            if (sequenciaAritmetica) {
                int razao = num2 - num1;
                System.out.println("Os números formam uma sequência aritmética.");
                System.out.println("A razão da sequência é: " + razao);
            } else {
                System.out.println("Os números não formam uma sequência aritmética.");
            }
        }
    /**
     * Escreva um programa que leia uma string e verifique se ela é um palíndromo, ou seja,
     * se a string lida é a mesma lida de trás para frente.
     */
    private static void questaoDez() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira uma frase ou palavra que seja um palíndromo:");
        String palavra = scanner.nextLine().toLowerCase();
        StringBuilder sb = new StringBuilder(palavra);
        String reversa = sb.reverse().toString().toLowerCase();
        if(limpaString(palavra).equals(limpaString(reversa))){
            System.out.printf("Isso mesmo, \"%s\" é um palímdromo\n", palavra);
        }else{
            System.out.printf("Ops, a palavra \"%s\" não é um palímdromo\n", palavra);
        }
    }

    private static String limpaString(String str) {
        return str.replaceAll("[áàâãä]", "a")
                .replaceAll("[éèêë]", "e")
                .replaceAll("[íìîï]", "i")
                .replaceAll("[óòôõö]", "o")
                .replaceAll("[úùûü]", "u")
                .replaceAll("[ç]", "c")
                .replaceAll("[^a-zA-Z]", "")
                .replaceAll("\\s", "");
    }
}

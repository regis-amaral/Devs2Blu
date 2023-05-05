package Aula03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculos {

    public static void main(String[] args) {
        parteUm();
        parteDois();
        parteTres();
        parteQuatro();
        parteCinco();
    }

    //Escreva um programa que leia dois números inteiros e exiba o resultado da soma, subtração, multiplicação, divisão e resto da divisão dos dois números.
    private static void parteUm(){
        System.out.println("PARTE 1");
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

    //Escreva um programa que verifique se um número é par ou ímpar utilizando o operador módulo.
    private static void parteDois(){
        System.out.println("PARTE 2");
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

    //Escreva um programa que leia a idade de uma pessoa e verifique se ela é maior ou igual a 18 anos utilizando o operador relacional de maior ou igual.
    private static void parteTres(){
        System.out.println("PARTE 3");
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

    //Escreva um programa que leia duas strings e verifique se elas são iguais utilizando o operador lógico de igualdade.
    private static void parteQuatro(){
        System.out.println("PARTE 4");
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

    //Escreva um programa que calcule a média de três notas e verifique se o aluno foi aprovado ou reprovado utilizando o operador lógico de comparação. Considere que a média para aprovação é 7.0.
    private static void parteCinco(){
        System.out.println("PARTE 5");
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

}

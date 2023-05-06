package Aula04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculos {
    public static void main(String[] args) {
        boolean exec = true;
        while(exec){
            System.out.println("\n\n#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("3 - Testar se o numero é primo");
            System.out.println("4 - Testar se o ano é bissexto");
            System.out.println("5 - Verifica se o número é multiplo de 3 e de 5");
            System.out.println("6 - Verifica se o número divisível por 2, 3 ou 5");
            System.out.println("7 - Verifica se a pessoa é maior de idade ou não");
            System.out.println("8 - Verifica se a idade permite votar ou não");
            System.out.println("9 - Determina o tipo de um triângulo");
            System.out.println("10 - Determina o maior entre três números");
            System.out.println("x - Sair");
            System.out.println("#########################################\n");
            Scanner scanner = new Scanner(System.in);
            switch(scanner.nextLine()){
                case "3" : parteTres(); break;
                case "4" : parteQuarto(); break;
                case "5" : parteCinco(); break;
                case "6" : parteSeis(); break;
                case "7" : parteSete(); break;
                case "8" : parteOito(); break;
                case "9" : parteNove(); break;
                case "10" : parteDez(); break;
                case "x" : exec=false; continue;
            }
            System.out.println("\nPressione qualquer tecla para continuar...");
            scanner.nextLine();
        }
    }
    
    private static void parteTres() {
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

    private static void parteQuarto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um ano em valor numérico (ex: 1900): ");
        int ano = scanner.nextInt();
        boolean t = false;
        if(ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            t = true;
        }
        System.out.println(t ? "É bissexto!" : "Não é bissexto!");
    }

    private static void parteCinco() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        if (numero % 3 == 0 && numero % 5 == 0) {
            System.out.println(numero + " é múltiplo de 3 e 5.");
        }else{
            System.out.println(numero + " não é múltiplo de 3 e 5.");
        };
    }

    private static void parteSeis() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        if(numero % 2 == 0 || numero % 3 == 0 || numero % 5 == 0){
            if(numero % 2 == 0){
                System.out.println(numero + " é divisível por 2");
            }
            if(numero % 3 == 0){
                System.out.println(numero + " é divisível por 3");
            }
            if(numero % 5 == 0){
                System.out.println(numero + " é divisível por 5");
            }
        }else{
            System.out.println(numero + " não é divisivel por 2, 3 ou 5");
        }
    }

    private static void parteSete(){
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

    private static void parteOito(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe sua idade: ");
        try {
            int idade = scanner.nextInt();
            if (idade >= 16 && idade <= 122) {
                System.out.println("Você pode votar");
            } else if (idade >= 0 && idade < 16) {
                System.out.println("Você ainda não pode votar");
            } else if (idade < 0){
                throw new InputMismatchException();
            }else{
                System.out.println("Ou você ta exagerando ou é o mais novo recordista do Guinness Book! E sim, você ainda pode votar!");
            }
        }catch (InputMismatchException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void parteNove() {
        double ladoA, ladoB, ladoC;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a medida de cada um dos três lados do triângulo:");
        System.out.print("Lado A: ");
        ladoA = scanner.nextDouble();
        System.out.print("Lado B: ");
        ladoB = scanner.nextDouble();
        System.out.print("Lado C: ");
        ladoC = scanner.nextDouble();

        if (ladoA == ladoB && ladoB == ladoC) {
            System.out.println("O triângulo é equilátero.");
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            System.out.println("O triângulo é isósceles.");
        } else {
            System.out.println("O triângulo é escaleno.");
        }
    }

    private static void parteDez() {
        double num1, num2, num3;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite três números:");
        System.out.print("Número 1: ");
        num1 = sc.nextDouble();
        System.out.print("Número 2: ");
        num2 = sc.nextDouble();
        System.out.print("Número 3: ");
        num3 = sc.nextDouble();

        if(num1 > num2 && num1 > num3){
            System.out.println(num1 + " é o maior número");
        }else if(num2 > num3){
            System.out.println(num2 + " é o maior");
        }else{
            System.out.println(num3 + " é o maior");
        }
    }
}

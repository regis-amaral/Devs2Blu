package Aula04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class LacosDeRepeticao {
    private static BufferedReader reader;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exec = true;
        while (exec) {
            System.out.println("#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Números pares entre 0 e o número informado");
            System.out.println("2 - Média aritmética da sequência de números informados");
            System.out.println("3 - Soma de todos os elementos de um array de inteiros");
            System.out.println("4 - Números ímpares entre 1 e o número informado");
            System.out.println("5 - Maior palavra inserida");
            System.out.println("6 - Maior número inteiro e sua posição dentro de um array");
            System.out.println("7 - Exibe números acima e abaixo da média de uma sequência de números");
            System.out.println("8 - Calcula o n-ésimo número em uma sequência de fibonacci");
            System.out.println("9 - Conta a quantidade de vezes que uma palavra aparece em uma sequência de palavras");
            System.out.println("10 - Calcula a mediana em um conjunto de números de inteiros");
            System.out.println("x - Sair");
            System.out.println("#########################################");
            try {
                String opcao = reader.readLine().replaceAll("\\s+", " ").trim();;
                switch (opcao) {
                    case "1": questaoUm(); break;
                    case "2": questaoDois(); break;
                    case "3": questaoTres(); break;
                    case "4": questaoQuatro(); break;
                    case "5": questaoCinco(); break;
                    case "6": questaoSeis(); break;
                    case "7": questaoSete(); break;
                    case "8": questaoOito(); break;
                    case "9": questaoNove(); break;
                    case "10": questaoDez(); break;
                    case "x": exec = false; continue;
                    default:
                        System.out.println("Opção inválida!");
                }
                System.out.println("\nPressione Enter para continuar...");
                reader.readLine();
            } catch (IOException e) {
                System.out.println("Você não inseriu uma entrada válida!");
            }
        }
    }

    private static void questaoUm(){
        System.out.println("Insira um número inteiro:");
        try{
            int numero = Integer.parseInt(reader.readLine());
            if (numero == 0)
                throw new InputMismatchException();
            if(numero >= -2 && numero <= 2){
                System.out.println("Não há números inteiros pares entre eles");
            }else {
                System.out.printf("Os números pares entre %d e %d são: \n", numero > 0 ? 0 : numero, numero > 0 ? numero : 0);
                for (int i = (numero > 0) ? 0 : numero; i != ((numero > 0) ? numero : 0); i++) {
                    if (i != 0 && i != numero && i % 2 == 0) {
                        System.out.print(i + " ");
                    }
                }
            }
        } catch (IOException | NumberFormatException | InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoDois(){
        System.out.println("Insira uma sequência de números separados por espaço");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            double total = 0;
            for(int i = 0; i < arrStr.length; i++){
                total += Double.parseDouble(arrStr[i]);
            }
            System.out.println("A média aritmética dos números informados é " + total / arrStr.length);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoTres(){
        System.out.println("Insira números inteiros, separados por espaços, para criar o array:");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            double total = 0;
            for(int i = 0; i < arrStr.length; i++){
                total += Integer.parseInt(arrStr[i]);
            }
            System.out.println("A soma de todos os valores do array é " + total);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoQuatro(){
        System.out.println("Insira um número inteiro:");
        try{
            int numero = Integer.parseInt(reader.readLine());
            if (numero == 0)
                throw new InputMismatchException();
            if(numero == -1 || numero == 1){
                System.out.println("Não há números inteiros ímpares entre eles");
            }else {
                System.out.printf("Os números ímpares entre %d e %d são: \n", numero > 1 ? 1 : numero, numero > 1 ? numero : 1);
                for (int i = (numero > 1) ? 1 : numero; i != ((numero > 1) ? numero : 1); i++) {
                    if (i != 1 && i != numero && i % 2 != 0) {
                        System.out.print(i + " ");
                    }
                }
            }
        } catch (IOException | NumberFormatException | InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoCinco(){
        System.out.println("Insira quantas palavras desejar usando espaço entre elas:");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            String maior = "";
            for (String s : arrStr){
                if(s.length() > maior.length())
                    maior = s;
            }
            System.out.println("A maior palavra digitada é " + maior);
        } catch (IOException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoSeis(){
        System.out.println("Insira números inteiros, separados por espaços, para criar o array:");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            int maior = 0, n, pos = 0;
            for(int i = 0; i < arrStr.length; i++){
                n = Integer.parseInt(arrStr[i]);
                if (i == 0) {
                    maior = n;
                    pos = i;
                }
                if(n > maior){
                    maior = n;
                    pos = i;
                }
            }
            System.out.printf("O maior número está na posição %d, o número %d. \n", pos + 1, maior);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoSete(){
        System.out.println("Insira uma sequência de números separados por espaço");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            double total = Arrays.stream(arrStr)
                    .mapToDouble(Double::parseDouble)
                    .sum();
            double media = total / arrStr.length;
            List<String> acimaMedia = new ArrayList<>();
            List<String> abaixoMedia = new ArrayList<>();
            for (String numStr : arrStr) {
                double num = Double.parseDouble(numStr);
                if (num > media) {
                    acimaMedia.add(numStr);
                } else if (num < media) {
                    abaixoMedia.add(numStr);
                }
            }
            System.out.println("Total: " + total);
            System.out.println("Quantidade de números informados: " + arrStr.length);
            System.out.println("Média: " + media);
            System.out.println("Números acima da média: " + acimaMedia);
            System.out.println("Números abaixo da média: " + abaixoMedia);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoOito(){
        // Testes comparados em https://www.calculatorsoup.com/calculators/discretemathematics/fibonacci-calculator.php
        System.out.println("Insira um número inteiro maior que 1");
        try{
            int posicao = Integer.parseInt(reader.readLine());
            if(posicao <= 1){
                throw new InputMismatchException();
            }
            int i = 1;
            BigInteger n1 = BigInteger.ZERO;
            BigInteger n2 = BigInteger.ONE;
            BigInteger f = BigInteger.ZERO;
            do{
                i++;
                f = n2.add(n1);
                n1 = n2;
                n2 = f;
            }while (i != posicao);
            System.out.println("O valor de Fibonacci na posição " + posicao + " é: " + f);
        } catch (IOException | NumberFormatException | InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoNove(){
        System.out.println("Insira quantas palavras desejar usando espaço entre elas:");
        try{
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] palavras = str.split("\s");
            Map<String, Integer> contagemPalavras = new HashMap<>();
            for (String palavra : palavras) {
                if (contagemPalavras.containsKey(palavra)) {
                    int contagemAtual = contagemPalavras.get(palavra);
                    contagemPalavras.put(palavra, contagemAtual + 1);
                } else {
                    contagemPalavras.put(palavra, 1);
                }
            }
            System.out.println("Contagem das palavras:");
            for (String palavra : contagemPalavras.keySet()) {
                int contagem = contagemPalavras.get(palavra);
                System.out.println(palavra + ": " + contagem);
            }
        } catch (IOException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoDez(){
        //Testes comparados em https://mediancalculator.com/pt
        System.out.println("Insira uma sequência de números separados por espaço");
        try{
            //Converte os dados recebidos
            String str = reader.readLine().replaceAll("\\s+", " ").trim();
            String[] arrStr = str.split("\s");
            Double[] array = Arrays.stream(arrStr)
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);
            //ordenar o array em ordem crescente
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        double temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            //calcula a mediana
            double mediana;
            if (array.length % 2 == 0) {
                int indice1 = array.length / 2 - 1;
                int indice2 = array.length / 2;
                mediana = (array[indice1] + array[indice2]) / 2;
            } else {
                int indice = array.length / 2;
                mediana = array[indice];
            }
            System.out.println("A mediana do array é: " + mediana);
        } catch (IOException | NumberFormatException | InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }
}

import java.util.*;

public class ArrayExercises {
    private static Scanner scanner;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        scanner = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println("#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Exibe o terceiro elemento de um array de inteiros com 5 números aleatórios");
            System.out.println("2 - Imprime a primeira letra da segunda string de um array com 3 strings");
            System.out.println("3 - Imprime os números pares em um array de inteiros aleatórios com 10 posições");
            System.out.println("4 - Média aritmética de um array com 6 números inteiros aleatórios");
            System.out.println("5 - Calcula a soma de todos os 4 elementos de um array de numeros reais");
            System.out.println("6 - Cria um array de inteiros com 5 entradas do usuário e imprime o maior entre eles");
            System.out.println("7 - Imprime todas as vogais encontradas no texto fornecido pelo usuário");
            System.out.println("8 - Cria um array com N elementos a partir da entrada do usuário e os exibe em ordem crescente");
            System.out.println("9 - Cria um array com N elementos e exibe os que são maiores que o ponto de corte informado");
            System.out.println("10 - Cria um array com N números reais e exibe o segundo maior valor");
            System.out.println("x - Sair");
            System.out.println("#########################################");
            String opcao = scanner.nextLine().replaceAll("\\s+", " ").trim();
            switch (opcao) {
                case "1": solveFirstQuestion(); break;
                case "2": solveSecondQuestion(); break;
                case "3": solveThirdQuestion(); break;
                case "4": solveFourthQuestion(); break;
                case "5": solveFifthQuestion(); break;
                case "6": solveSixthQuestion(); break;
                case "7": solveSeventhQuestion(); break;
                case "8": solveEighthQuestion(); break;
                case "9": solveNinthQuestion(); break;
                case "10": solveTenthQuestion(); break;
                case "x": exec = false; continue;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    /**
     * 1. Crie um array com 5 números inteiros e exiba o valor do terceiro elemento.
     */
    private static void solveFirstQuestion(){
        int[] numbers = new Random().ints(5, 1, 100).toArray();
        System.out.println(Arrays.toString(numbers));
        System.out.println("O terceiro elemento do array de inteiros é " + numbers[2]);
    }

    /**
     * 2. Crie um array com 3 strings e exiba a primeira letra da segunda string.
     */
    private static void solveSecondQuestion(){
        String[] wordsList = {"banana", "abacaxi", "laranja"};
        System.out.println(Arrays.toString(wordsList));
        System.out.println("A primeira letra da segunda string é: " + wordsList[1].charAt(0));
    }

    /**
     * 3. Crie um array com 10 elementos e preencha-o com números aleatórios. Em seguida,
     * exiba todos os números pares do array.
     */
    private static void solveThirdQuestion(){
        int[] numbers = new Random().ints(10, 1, 100).toArray();
        System.out.println(Arrays.toString(numbers));
        System.out.print("Números pares no array: ");
        for(int i : numbers){
            if(i % 2 == 0)
                System.out.print(" " + i);
        }
    }

    /**
     * 4. Crie um array com 6 números inteiros e calcule a média aritmética de todos os
     * elementos.
     */
    private static void solveFourthQuestion(){
        int[] numbers = new Random().ints(6, 1, 100).toArray();
        int total = Arrays.stream(numbers).sum();
        System.out.println(Arrays.toString(numbers));
        System.out.println("A média aritmética do array é  " + total / numbers.length);
    }

    /**
     * 5. Crie um array com 4 números reais e calcule a soma de todos os elementos.
     */
    private static void solveFifthQuestion(){
        double[] numbers = new Random().doubles(4, -100, 100).toArray();
        double total = Arrays.stream(numbers).sum();
        System.out.println(Arrays.toString(numbers));
        System.out.println("A soma dos elementos é " + total);
    }

    /**
     * 1. Crie um programa que receba do usuário 5 números inteiros e armazene-os em um
     * array. Em seguida, o programa deve exibir o maior número informado pelo usuário.
     */
    private static void solveSixthQuestion(){
        int[] numbers = new int[5];
        try{
            for (int i = 0; i < numbers.length; i++){
                System.out.println("Digite um valor para a posição " + (i + 1));
                numbers[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(numbers));
            Arrays.sort(numbers);
            System.out.println("O maior número é " + numbers[numbers.length-1]);
            scanner.nextLine();
        }catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * 2. Crie um programa que receba do usuário um texto e armazene-o em um array de
     * caracteres. O programa deve exibir a quantidade de vogais presentes no texto
     * informado.
     */
    private static void solveSeventhQuestion(){
        System.out.println("Insira um texto:");
        char[] chars = scanner.nextLine().toCharArray();
        int counter = 0;
        for (char c : chars){
            if (String.valueOf(c).matches("[aeiouáàâãäéèêëíìîïóòôõöúùûüAEIOUÁÀÂÃÄÉÈÊËÍÌÎÏÓÒÔÕÖÚÙÛÜ]")) {
                counter++;
            }
        }
        System.out.printf("O texto possui %d vogais", counter);
    }

    /**
     * 3. Crie um programa que receba do usuário um número inteiro N e um array com N
     * elementos. O programa deve ordenar os elementos do array em ordem crescente e
     * exibi-los na tela.
     */
    private static void solveEighthQuestion(){
        try{
            System.out.println("Informe o tamanho do array desejado:");
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for(int i = 0; i < n; i++){
                System.out.println("Digite um número inteiro para a posição " + (i + 1));
                numbers[i] = scanner.nextInt();
            }
            Arrays.sort(numbers);
            System.out.println("Array: " + Arrays.toString(numbers));
            scanner.nextLine();
        }catch (InputMismatchException | NumberFormatException | NegativeArraySizeException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * 4. Crie um programa que receba do usuário um array com N números inteiros e um
     * número M. O programa deve exibir a quantidade de elementos do array que são
     * maiores que M.
     */
    private static void solveNinthQuestion(){
        try{
            System.out.println("Informe o tamanho do array desejado:");
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for(int i = 0; i < n; i++){
                System.out.println("Digite um número inteiro para a posição " + (i + 1));
                numbers[i] = scanner.nextInt();
            }
            System.out.println("Informe o número de corte");
            int m = scanner.nextInt();
            Arrays.sort(numbers);
            System.out.println("Os números maiores que o ponto de corte são:");
            for(int i : numbers){
                if(i > m)
                    System.out.println(i);
            }
            scanner.nextLine();
        }catch (InputMismatchException | NegativeArraySizeException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * 5. Crie um programa que receba do usuário um array com N números reais e encontre
     * o segundo maior valor presente no array
     */
    private static void solveTenthQuestion(){
        try{
            System.out.println("Informe o tamanho do array desejado:");
            int n = scanner.nextInt();
            double[] numbers = new double[n];
            for(int i = 0; i < n; i++){
                System.out.println("Digite um número real para a posição " + (i + 1));
                numbers[i] = scanner.nextDouble();
            }
            System.out.println("Array: " + Arrays.toString(numbers));
            Arrays.sort(numbers);
            System.out.println("O segundo maior número é " + numbers[numbers.length-2]);
            scanner.nextLine();
        }catch (InputMismatchException | NumberFormatException | NegativeArraySizeException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }
}

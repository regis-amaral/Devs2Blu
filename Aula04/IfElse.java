package Aula04;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class IfElse {
    private static Scanner scanner;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        scanner = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println("\n\n#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Maior entre dois números");
            System.out.println("2 - Verifica se pode votar com base no ano de nascimento");
            System.out.println("3 - Verifica senha");
            System.out.println("4 - Compra de maçãs");
            System.out.println("5 - Valores em ordem crescente");
            System.out.println("6 - Peso ideal");
            System.out.println("7 - Polígonos regulares");
            System.out.println("8 - Maior entre três números");
            System.out.println("9 - Tipo do triângulo pelo tamanho dos lados");
            System.out.println("10 - Tipo do triângulo pelas medidas dos ângulos");
            System.out.println("x - Sair");
            System.out.println("#########################################\n");
            switch (scanner.nextLine()) {
                case "1": questaoUm(); break;
                case "2": questaoDois(); break;
                case "3": questaoTres(); break;
                case "4": questaoQuatro(); break;
                case "5": questaoCinco(); break;
                case "6": questaoSeis(); break;
                case "7": questaoSete(); break;
                case "8": questaoNove(); break;
                case "9": questaoDez(); break;
                case "10": questaoOnze(); break;
                case "x": exec = false; continue;
                default: continue;
            }
            scanner.nextLine();
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
        scanner.close();
    }

    /**
     * Escreva um programa para ler 2 valores (considere que não serão informados
     * valores iguais) e escreva o maior deles.
     */
    private static void questaoUm() {
        try {
            System.out.println("Digite dois valores diferentes (ex: 5 e 2.99)");
            System.out.println("Primeiro valor: ");
            double numIntA = scanner.nextDouble();
            System.out.println("Segundo valor: ");
            double numIntB = scanner.nextDouble();
            if (numIntA > numIntB)
                System.out.println(numIntA + " é o maior número digitado");
            else if (numIntB > numIntA)
                System.out.println(numIntB + " é o maior numéro digtitado");
            else
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa para ler o ano de nascimento de uma pessoa e escrever uma
     * mensagem que diga se ela poderá ou não votar este ano (não é necessário
     * considerar o mês em que ela nasceu).
     */
    private static void questaoDois() {
        try {
            System.out.println("Informe seu ano de nascimento:");
            int anoNascimento = scanner.nextInt();
            LocalDate now = LocalDate.now();
            int yearNow = now.getYear();
            if(anoNascimento <= (yearNow - 16)){
                System.out.println("Você poderá votar esse ano!");
            }else{
                System.out.println("Você não poderá votar essse ano!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que verifique a validade de uma senha fornecida pelo usuário. A
     * senha válida é o número 1234. Devem ser impressas as seguintes mensagens:
     * ACESSO PERMITIDO caso a senha seja válida.
     * ACESSO NEGADO caso a senha seja inválida.
     */
    private static void questaoTres(){
        String senhaValida = "1234";
        System.out.println("Digite sua senha:");
        String senhaFornecida = scanner.next();
        if(senhaValida.equals(senhaFornecida)){
            System.out.println("ACESSO PERMITIDO");
        }else{
            System.out.println("ACESSO NEGADO");
        }
    }

    /**
     * As maçãs custam R$ 0,30 cada se forem compradas menos do que uma dúzia, e R$ 0,25
     * se forem compradas pelo menos doze. Escreva um programa que leia o número de maçãs
     * compradas, calcule e escreva o valor total da compra.
     */
    public static void questaoQuatro(){
        double total;
        double preco1 = 0.30, preco2 = 0.25;
        System.out.println("Digite a quantidade de maçãs que deseja comprar:");
        try{
            int qtd = scanner.nextInt();
            if(qtd < 1)
                throw new InputMismatchException();
            if(qtd < 12){
                total = qtd * preco1;
            }else{
                total = qtd * preco2;
            }
            Locale locale = new Locale("pt", "BR"); // Configura o locale para o Brasil
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            String valorFormatado = currencyFormatter.format(total);
            System.out.println("O total de sua compra é " + valorFormatado);
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa para ler 3 valores inteiros (considere que não serão lidos valores iguais)
     * e escrevê-los em ordem crescente.
     */
    private static void questaoCinco(){
        try {
            System.out.println("Digite três valores inteiros distintos");
            System.out.println("Primeiro valor: ");
            int numIntA = scanner.nextInt();
            System.out.println("Segundo valor: ");
            int numIntB = scanner.nextInt();
            System.out.println("Terceiro valor: ");
            int numIntC = scanner.nextInt();
            if(numIntA == numIntB || numIntA == numIntC || numIntB == numIntC){
                throw new InputMismatchException();
            }
            int[] valores = {numIntA,numIntB,numIntC};
            Arrays.sort(valores);
            System.out.printf("A ordem crescente é %d, %d e %d", valores[0], valores[1], valores[2]);
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Tendo como entrada a altura e o sexo (codificado da seguinte forma: 1:feminino
     * 2:masculino) de uma pessoa, construa um programa que calcule e imprima seu peso ideal,
     * utilizando as seguintes
     * Fórmulas:
     * - para homens: (72.7 * Altura) – 58
     * - para mulheres: (62.1 * Altura) – 44.7
     */
    private static void questaoSeis(){
        try {
            System.out.println("Selecione em dos seguintes sexos:");
            System.out.println("1 - Feminino");
            System.out.println("2 - Masculino");
            int sexo = scanner.nextInt();
            if(!(sexo == 1 || sexo == 2))
                throw new InputMismatchException();
            System.out.println("Informe a altura no formato 0.00");
            float altura = scanner.nextFloat();
            //aceita apenas valores entre as alturas da menor e da maior pessoa que ja existiu
            if(altura < 0.56 || altura > 2.50)
                throw new InputMismatchException();
            float pesoIdeal = (float) (sexo == 1 ? (62.1 * altura) - 44.7 : (72.7 * altura) - 58);
            if(pesoIdeal < 1)
                System.out.println("A fórmula utilizada parece ser incompatível com a altura informada.");
            else
                System.out.println("Seu peso ideal é " + pesoIdeal);
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa para ler o número de lados de um polígono regular e a medida do
     * lado (em cm). Calcular e imprimir o seguinte:
     * − Se o número de lados for igual a 3 escrever TRIÂNGULO e o valor da área
     * − Se o número de lados for igual a 4 escrever QUADRADO e o valor da sua área.
     * − Se o número de lados for igual a 5 escrever PENTÁGONO.
     */
    private static void questaoSete() {
        System.out.println("Informe o número de lados do polígono [3, 4 ou 5]:");
        try {
            int qtdLados = scanner.nextInt();
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Informe a medida do lado em cm:");
            float lado = scanner.nextFloat();
            if (qtdLados == 3) {
                System.out.println("TRIÂNGULO");
                double area = Math.pow(lado, 2) * (Math.sqrt(3)) / 4;
                System.out.println("Área: " + df.format(area) + "cm");
            } else if (qtdLados == 4) {
                System.out.println("QUADRADO");
                System.out.println("Área: " + df.format((lado * lado)) + "cm");
            } else if (qtdLados == 5) {
                System.out.println("PENTÁGONO");
                double area = (5 * lado * lado) / (4.0 * Math.tan(Math.PI / 5));
                System.out.println("Área: " + df.format(area) + "cm");
            } else if(qtdLados < 3){
                System.out.println("NÃO É UM POLÍGONO");
            } else {
                System.out.println("POLÍGONO NÃO IDENTIFICADO.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa para ler 3 valores inteiros e escrever o maior deles. Considere que
     * o usuário não informará valores iguais
     */
    private static void questaoNove() {
        System.out.println("Digite três valores distintos:");
        try{
            System.out.print("Primeiro valor: ");
            double num1 = scanner.nextDouble();
            System.out.print("Segundo valor: ");
            double num2 = scanner.nextDouble();
            System.out.print("Terceiro valor: ");
            double num3 = scanner.nextDouble();

            if(num1 > num2 && num1 > num3){
                System.out.println(num1 + " é o maior número");
            }else if(num2 > num3){
                System.out.println(num2 + " é o maior");
            }else{
                System.out.println(num3 + " é o maior");
            }
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    /**
     * Escreva um programa que leia as medidas dos lados de um triângulo e escreva se ele é
     * Equilátero, Isósceles ou Escaleno. Sendo que:
     * − Triângulo Equilátero: possui os 3 lados iguais.
     * − Triângulo Isóscele: possui 2 lados iguais.
     * − Triângulo Escaleno: possui 3 lados diferentes.
     */
    private static void questaoDez(){
        System.out.println("Informe as medidas de cada um dos 3 lados do triângulo");
        try {
            System.out.println("Lado A:");
            double ladoA = scanner.nextInt();
            System.out.println("Lado B");
            double ladoB = scanner.nextInt();
            System.out.println("Lado C");
            double ladoC = scanner.nextInt();
            if(!verificaPossibilidadeDoTriangulo(ladoA, ladoB, ladoC)){
                System.out.println("É impossível montar um triângulo com as medidas informadas");
            }else if(ladoA == ladoB && ladoB == ladoC){
                System.out.println("O triângulo é Equilátero");
            }else if(ladoA == ladoB || ladoA == ladoC || ladoB == ladoC){
                System.out.println("O triângulo é Isóscele");
            }else{
                System.out.println("O triângulo é Escaleno");
            }
        } catch (InputMismatchException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static boolean verificaPossibilidadeDoTriangulo(double a, double b, double c){
        return a + b > c;
    }

    /**
     * Escreva um programa que leia o valor de 3 ângulos de um triângulo e escreva se o
     * triângulo é Acutângulo, Retângulo ou Obtusângulo. Sendo que:
     * − Triângulo Retângulo: possui um ângulo reto. (igual a 90º)
     * − Triângulo Obtusângulo: possui um ângulo obtuso. (maior que90º)
     * − Triângulo Acutângulo: possui três ângulos agudos. (menor que 90º
     */
    private static void questaoOnze(){
        System.out.println("Informe o valor de cada ângulo do triângulo");
        System.out.println("Ângulo A:");
        double anguloA = scanner.nextDouble();
        System.out.println("Ângulo B");
        double anguloB = scanner.nextDouble();
        System.out.println("Ângulo C");
        double anguloC = scanner.nextDouble();
        if(!verificaPossibilidadeDoTrianguloPelosAngulos(anguloA, anguloB, anguloC)){
            System.out.println("É impossível montar um triângulo com os ângulos informados.");
        }else if(anguloA < 90 && anguloB < 90 && anguloC < 90){
            System.out.println("É um triângulo Acutângulo.");
        }else if(anguloA == 90 || anguloB == 90 || anguloC == 90){
            System.out.println("É um triângulo Retângulo.");
        }else{
            System.out.println("É um triângulo Obtusângulo.");
        }
    }

    private static boolean verificaPossibilidadeDoTrianguloPelosAngulos(double a, double b, double c){
        if(a <= 0 || b <= 0 || c <= 0){
            return false;
        }
        return (a + b + c) == 180;
    }
}

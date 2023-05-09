package Aula04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;

public class SwitchCase {

    private static BufferedReader reader;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exec = true;
        while (exec) {
            System.out.println("#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Classificação do produto pelo código");
            System.out.println("2 - Média de duas notas de um aluno");
            System.out.println("3 - Operações matemáticas básicas");
            System.out.println("4 - Compra de lanches");
            System.out.println("x - Sair");
            System.out.println("#########################################");
            try{
                String opcao = reader.readLine().replaceAll("\\s+", " ").trim();
                switch (opcao) {
                    case "1": questaoUm(); break;
                    case "2": questaoDois(); break;
                    case "3": questaoTres(); break;
                    case "4": questaoQuatro(); break;
                    case "x": exec = false; continue;
                    default:
                        System.out.println("Opção inválida!");
                }
                System.out.println("\nPressione Enter para continuar...");
                reader.readLine();
            }catch (IOException e){
                System.out.println("Você não inseriu uma entrada válida!");
            }
        }
    }

    private static void questaoUm(){
        System.out.println("Insira o código do produto:");
        try{
            String codigo = reader.readLine();
            switch (codigo){
                case "1":
                    System.out.println("Alimento não-perecível.");
                    break;
                case "2":
                case "3":
                case "4":
                    System.out.println("Alimento perecível.");
                    break;
                case "5":
                case "6":
                    System.out.println("Vestuário.");
                    break;
                case "7":
                    System.out.println("Higiene pessoal.");
                    break;
                case "8":
                case "9":
                case "10":
                case "11":
                case "12":
                case "13":
                case "14":
                case "15":
                    System.out.println("Limpeza e utensílios domésticos.");
                    break;
                default:
                    System.out.println("Código inválido!");
            }
        }catch (IOException e){
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoDois(){
        System.out.println("Informe as duas notas do aluno [0 a 10]:");
        try{
            System.out.println("Primeira nota: ");
            double nota1 = Double.parseDouble(reader.readLine().replaceAll("\\s+", " ").trim());
            if(nota1 < 0 || nota1 > 10)
                throw new InputMismatchException();
            System.out.println("Segunda nota: ");
            double nota2 = Double.parseDouble(reader.readLine().replaceAll("\\s+", " ").trim());
            if(nota2 < 0 || nota2 > 10)
                throw new InputMismatchException();
            double media = (nota1 + nota2) /2;
            int status = media >= 7.1 ? 1 : media >= 4.1 ? 0 : -1;
            switch (status){
                case 1:
                    System.out.println("Média: " + media);
                    System.out.println("Aprovado");
                    break;
                case 0:
                    System.out.println("Média: " + media);
                    System.out.println("Exame");
                    break;
                case -1:
                    System.out.println("Média: " + media);
                    System.out.println("Reprovado");
                    break;
            }
        } catch (InputMismatchException | IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoTres(){
        System.out.println("Informe dois números...");
        try{
            System.out.println("Primeiro número: ");
            double num1 = Double.parseDouble(reader.readLine().replaceAll("\\s+", " ").trim());
            System.out.println("Segundo número: ");
            double num2 = Double.parseDouble(reader.readLine().replaceAll("\\s+", " ").trim());
            boolean execute = true;
            while (execute){
                System.out.println("Escolha uma das opções");
                System.out.println("1 - Média dos números");
                System.out.println("2 - Diferença entre os números");
                System.out.println("3 - Produto entre os números");
                System.out.println("4 - Divisão do primeiro pelo segundo número");
                System.out.println("x - Modificar valores ");
                String opcao = reader.readLine();
                switch (opcao){
                    case "1":
                        System.out.println("Média: " + ((num1 + num2) / 2));
                        break;
                    case "2":
                        System.out.println("Diferença: " + (num1 > num2 ? num1 - num2 : num2 - num1));
                        break;
                    case "3":
                        System.out.println("Produto: " + (num1 * num2));
                        break;
                    case "4":
                        System.out.println("Divisão: " + (num1 / num2));
                        break;
                    case "x":
                        System.out.println("Primeiro número: ");
                        num1 = Double.parseDouble(reader.readLine());
                        System.out.println("Segundo número: ");
                        num2 = Double.parseDouble(reader.readLine());
                        break;
                    default:
                        System.out.println("Opção inválida!\nEncerrando execução...");
                        execute = false;
                }
            }
        } catch (InputMismatchException | IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }

    private static void questaoQuatro(){
        System.out.println("################ CARDÁPIO ##################");
        System.out.println("100 - Cachorro quente ...............R$ 1,70");
        System.out.println("101 - Bauru simples .................R$ 2,30");
        System.out.println("102 - Bauru com ovo .................R$ 2,60");
        System.out.println("103 - Hambúrguer ....................R$ 2,40");
        System.out.println("104 - Cheeseburguer .................R$ 2,50");
        System.out.println("105 - Refrigerante ..................R$ 1,00");
        System.out.println("\nInforme o código do item a ser adquirido:");
        try{
            int produto = Integer.parseInt(reader.readLine().replaceAll("\\s+", " ").trim());
            System.out.println("Informe a quantidade:");
            int quantidade = Integer.parseInt(reader.readLine().replaceAll("\\s+", " ").trim());
            if(quantidade < 1)
                throw new InputMismatchException();
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            switch (produto){
                case 100:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 1.70)));
                    break;
                case 101:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 2.30)));
                    break;
                case 102:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 2.60)));
                    break;
                case 103:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 2.40)));
                    break;
                case 104:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 2.50)));
                    break;
                case 105:
                    System.out.println("Valor final: " + currencyFormatter.format((quantidade * 1.0)));
                    break;
                default:
                    System.out.println("Código do item não encontrado!");
            }
        } catch (InputMismatchException | IOException | NumberFormatException e) {
            System.out.println("Você não inseriu uma entrada válida!");
        }
    }
}

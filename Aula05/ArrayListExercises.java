package Aula05;

import java.text.NumberFormat;
import java.util.*;

public class ArrayListExercises {
    private static Scanner scanner;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        scanner = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println("#########################################");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Cria uma lista com as strings: Maçã, Banana e Laranja");
            System.out.println("2 - Cria uma lista de inteiros com os números de 1 a 5 e os imprime");
            System.out.println("3 - Cria uma lista de doubles com valores aleatórios e calcula a média deles");
            System.out.println("4 - Cria uma lista de Pessoas e ordena pela idade");
            System.out.println("5 - Cria uma lista de strings e remove todos os elementos que contenham a letra a");
            System.out.println("6 - Cria uma lista de produtos e ordena pelo preço");
            System.out.println("7 - Cria duas listas de inteiros e exibe a interseção entre elas");
            System.out.println("8 - Divide a lista de pessoas em duas listas, uma commaiores de idade e outra com menores de idade");
            System.out.println("9 - Cria uma lista de alunos e calcula a média deles");
            System.out.println("10 - Cria uma lista de string e ordena a lista pela ordemn alfabética inversa");
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
     * 1. Crie uma lista de strings vazia e adicione três elementos a ela: "Maçã", "Banana" e
     * "Laranja".
     */
    private static void solveFirstQuestion(){
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Maçã");
        fruitList.add("Banana");
        fruitList.add("Laranja");
        System.out.println(fruitList);
    }

    /**
     * 2. Crie uma lista de inteiros com os números de 1 a 5 e imprima cada elemento da
     * lista.
     */
    private static void solveSecondQuestion(){
        List<Integer> listOfIntegers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            listOfIntegers.add(i);
        }
        for (int e : listOfIntegers) {
            System.out.println(e);
        }
    }

    /**
     * 3. Crie uma lista de doubles com valores aleatórios e calcule a média dos valores
     */
    private static void solveThirdQuestion(){
        List<Double> numbers = new ArrayList<>();
        Random random = new Random();
        int numberOfValues = 5;
        for (int i = 0; i < numberOfValues; i++) {
            double value = random.nextDouble();
            numbers.add(value);
        }
        double sum = 0.0;
        for (double value : numbers) {
            sum += value;
        }
        double average = sum / numbers.size();
        System.out.println("Valores: " + numbers);
        System.out.println("Média: " + average);
    }

    /**
     * 4. Crie uma lista de objetos da classe Pessoa, com nome e idade, e ordene a lista por
     * idade.
     */
    private static void solveFourthQuestion(){
        var personList = new ArrayList<Person>();
        personList.add(new Person("Regis", 36));
        personList.add(new Person("Daniele", 23));
        personList.add(new Person("João", 40));
        personList.add(new Person("Maria", 28));
        personList.add(new Person("Pedro", 32));
        personList.add(new Person("Ana", 45));
        personList.add(new Person("Carlos", 19));
        personList.add(new Person("Mariana", 31));
        personList.add(new Person("Lucas", 27));
        personList.add(new Person("Julia", 39));
        personList.add(new Person("Rafael", 24));
        personList.add(new Person("Patricia", 37));
        personList.add(new Person("Fernando", 42));
        personList.add(new Person("Camila", 29));
        personList.add(new Person("Guilherme", 33));
        personList.add(new Person("Isabela", 22));
        personList.add(new Person("Marcelo", 47));
        personList.add(new Person("Larissa", 26));
        personList.add(new Person("Ricardo", 34));
        personList.add(new Person("Vanessa", 41));

        Collections.sort(personList, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        for (Person person : personList) {
            System.out.println(person.getName() + ", " + person.getAge());
        }

    }

    /**
     * 5. Crie uma lista de strings e remova todos os elementos da lista que contenha a letra
     * "a".
     */
    private static void solveFifthQuestion(){
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("banana");
        wordList.add("car");
        wordList.add("dog");
        wordList.add("elephant");
        wordList.add("fruit");
        wordList.add("grape");
        wordList.add("house");
        wordList.add("internet");
        wordList.add("juice");
        System.out.println("Lista inicial: " + wordList);
        Iterator<String> iterator = wordList.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.contains("a")) {
                iterator.remove();
            }
        }
        System.out.println("Lista sem a letra a: " + wordList);
    }

    /**
     * 1. Crie uma lista de objetos da classe Produto, com nome e preço, e ordene a lista por
     * preço.
     */
    private static void solveSixthQuestion(){
        var productList = new ArrayList<Product>();
        productList.add(new Product("Arroz 5Kg", 12.90));
        productList.add(new Product("Feijão 1Kg", 5.50));
        productList.add(new Product("Macarrão Espaguete", 3.20));
        productList.add(new Product("Óleo de Soja 900ml", 4.90));
        productList.add(new Product("Leite Integral 1L", 3.99));
        productList.add(new Product("Açúcar Refinado 1Kg", 2.80));
        productList.add(new Product("Café em Pó 500g", 8.50));
        productList.add(new Product("Biscoito Cream Cracker", 2.99));
        productList.add(new Product("Sabonete Líquido 200ml", 6.20));
        productList.add(new Product("Shampoo Anticaspa 400ml", 12.50));
        productList.add(new Product("Condicionador Hidratante 300ml", 9.90));
        productList.add(new Product("Desodorante Roll-On", 5.80));
        productList.add(new Product("Pasta de Dente 90g", 3.30));
        productList.add(new Product("Escova de Dentes", 2.50));
        productList.add(new Product("Papel Higiênico com 4 rolos", 7.99));
        productList.add(new Product("Amaciante de Roupas 1L", 11.75));
        productList.add(new Product("Detergente Líquido 500ml", 2.90));
        productList.add(new Product("Limpador Multiuso 500ml", 4.50));
        productList.add(new Product("Esponja de Limpeza", 1.80));
        productList.add(new Product("Água Sanitária 1L", 3.20));

        Collections.sort(productList, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        NumberFormat brazilianCurrencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Product product : productList) {
            System.out.println(brazilianCurrencyFormat.format(product.getPrice()) + " - " + product.getName());
        }
    }

    /**
     * 2. Crie duas listas de inteiros e calcule a interseção entre elas (ou seja, os números
     * que estão presentes nas duas listas).
     */
    private static void solveSeventhQuestion(){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
            list2.add(i + 5);
        }
        System.out.println("Lista 1: " + list1);
        System.out.println("Lista 2: " + list2);
        List<Integer> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("Interseção: " + intersection);
    }

    /**
     * 3. Crie uma lista de objetos da classe Pessoa, com nome e idade, e divida a lista em
     * duas listas distintas: uma com pessoas com idade maior ou igual a 18 anos e outra
     * com pessoas com idade menor que 18 anos.
     */
    private static void solveEighthQuestion(){
        var personList = new ArrayList<Person>();
        personList.add(new Person("Regis", 36));
        personList.add(new Person("Daniele", 23));
        personList.add(new Person("João", 10));
        personList.add(new Person("Maria", 28));
        personList.add(new Person("Pedro", 12));
        personList.add(new Person("Ana", 45));
        personList.add(new Person("Carlos", 19));
        personList.add(new Person("Mariana", 31));
        personList.add(new Person("Lucas", 27));
        personList.add(new Person("Julia", 39));
        personList.add(new Person("Rafael", 18));
        personList.add(new Person("Patricia", 17));
        personList.add(new Person("Fernando", 42));
        personList.add(new Person("Camila", 29));
        personList.add(new Person("Guilherme", 33));
        personList.add(new Person("Isabela", 22));
        personList.add(new Person("Marcelo", 47));
        personList.add(new Person("Larissa", 26));
        personList.add(new Person("Ricardo", 14));
        personList.add(new Person("Vanessa", 17));
        Collections.sort(personList, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        var minorList = new ArrayList<Person>();
        var adultList = new  ArrayList<Person>();
        for(Person p : personList){
            if(p.getAge() >= 18){
                adultList.add(p);
            }else{
                minorList.add(p);
            }
        }
        System.out.println("MAIORES DE IDADE:");
        adultList.forEach(person -> {
            System.out.println(person.getAge() + " - "+ person.getName());
        });
        System.out.println("MENORES DE IDADE:");
        minorList.forEach(person -> {
            System.out.println(person.getAge() + " - "+ person.getName());
        });
    }

    /**
     * 4. Crie uma lista de objetos da classe Aluno, com nome e nota, e calcule a média das
     * notas dos alunos.
     */
    private static void solveNinthQuestion(){
        var studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "José", 5.0f, 6.1f, 7.0f));
        studentList.add(new Student(2, "Maria", 8.0f, 5.0f, 9.9f));
        studentList.add(new Student(3, "Joaquina", 10.0f, 10f, 10f));
        studentList.add(new Student(4, "Epitáfio", 8.0f, 5.0f, 9.9f));
        studentList.add(new Student(5, "Aldemar", 6.1f, 4.4f, 5.7f));
        studentList.add(new Student(6, "Zaira", 5.0f, 6.1f, 7.9f));
        studentList.add(new Student(7, "Marcolina", 8.2f, 8.2f, 9.9f));
        studentList.add(new Student(8, "Izolde", 10.0f, 9.1f, 7.7f));
        studentList.add(new Student(9, "Jairo", 5.0f, 6.1f, 7.7f));
        studentList.add(new Student(10, "Babeto", 6.0f, 7.8f, 7.4f));
        studentList.add(new Student(11, "Lindolfo", 10.0f, 10f, 10f));
        Collections.sort(studentList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        studentList.forEach(student -> {
            System.out.println(student.getName() + " - Média: " + (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3 );
        });
    }

    /**
     * 5. Crie uma lista de strings e ordene a lista por ordem alfabética inversa
     */
    private static void solveTenthQuestion(){
        List<String> wordList = new ArrayList<String>();
        wordList.add("casa");
        wordList.add("carro");
        wordList.add("banana");
        wordList.add("livro");
        wordList.add("amigo");
        wordList.add("tempo");
        wordList.add("felicidade");
        wordList.add("natureza");
        wordList.add("computador");
        wordList.add("praia");
        wordList.add("cidade");
        wordList.add("jardim");
        wordList.add("música");
        wordList.add("chocolate");
        wordList.add("viagem");
        Collections.sort(wordList, (p1, p2) -> p2.compareTo(p1));
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}

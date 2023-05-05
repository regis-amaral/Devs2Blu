package Aula03;

public class Converter {
    public static void main(String[] args) {

        //Converta um int em um long e armazene o resultado em uma variável do tipo long
        int numInt = 10;
        long numLong = (long) numInt;
        System.out.println("1. int para loong: " + numLong);

        //Converta um float em um double e armazene o resultado em uma variável do tipo double
        float numFloat = 3.14F;
        double numDouble = (double) numFloat;
        System.out.println("2. float para double: " + numDouble);

        // Converta um double em um int e armazene o resultado em uma variável do tipo int
        numDouble = 3.14;
        numInt = (int) numDouble;
        System.out.println("3. double para int: " + numInt);

        //Converta um char em um int e armazene o resultado em uma variável do tipo int
        char umChar = 'a';
        numInt = (char) umChar;
        System.out.println("4. char para int: " + numInt);

        //Converta um int em uma String e armazene o resultado em uma variável do tipo String
        numInt = 10;
        String str = Integer.toString(numInt);
        System.out.println("5. int para uma String: " + str);
    }
}

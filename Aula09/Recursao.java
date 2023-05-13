package Aula09;

public class Recursao {

    public static void main(String[] args) {
        var n = 15;
        var valorFibonacci = fibonacciCalc(n);
        System.out.println(valorFibonacci);
    }

    public static int fibonacciCalc(int n){
        if(n <= 1){
            return n;
        }else{
            return fibonacciCalc(n - 1) + fibonacciCalc(n - 2);
        }
    }
}

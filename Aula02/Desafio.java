public class Desafio {

    public static void main(String[] args) {
        boolean teste = !(true && false);
        System.out.print("1. O resultado do teste !(true && false) é ");
        System.out.println(teste);

        teste = !(false || true);
        System.out.print("2. O resultado do teste !(false || true) é ");
        System.out.println(teste);

        teste = true && true;
        System.out.print("3. O resultado do teste true && true é ");
        System.out.println(teste);

        teste = (true && false) || (false && true);
        System.out.print("4. O resultado do teste (true && false) || (false && true) é ");
        System.out.println(teste);

        teste = (true || false) && (false || true);
        System.out.print("5. O resultado do teste (true || false) && (false || true) é ");
        System.out.println(teste);

        teste = (5>3) && (2<4);
        System.out.print("6. O resultado do teste (5>3) && (2<4) é ");
        System.out.println(teste);

        teste = (7==5) || (3>1);
        System.out.print("7. O resultado do teste (7==5) || (3>1) é ");
        System.out.println(teste);

        teste = !(4<2);
        System.out.print("8. O resultado do teste !(4<2) é ");
        System.out.println(teste);

        teste = (3*4) >= 10;
        System.out.print("9. O resultado do teste (3*4) >= 10 é ");
        System.out.println(teste);

        teste = (8%2) == 0;
        System.out.print("10. O resultado do teste (8%2) == 0 é ");
        System.out.println(teste);
    }
}
package aula01;
public class App {
    public static void main(String[] args) throws Exception {

        Girafa girafales = new Girafa();
        girafales.setAltura(10.0);
        girafales.setCodigo("COD1");
        girafales.setPeso(564.5);;
        girafales.setQuantidadespatas(3);
        girafales.setVelocidade(20.0);

        Girafa melman = new Girafa();
        melman.setAltura(23.0);
        melman.setCodigo("COD3");
        melman.setPeso(54.5);
        melman.setQuantidadespatas(4);
        melman.setVelocidade(21.0);

        System.out.println("Olá, mundo!");
    }
}

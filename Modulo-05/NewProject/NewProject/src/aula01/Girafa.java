package aula01;
public class Girafa {
    private double altura;
    private double peso;
    private double velocidade;
    private int quantidadespatas;
    private String codigo;

    public Girafa(){
        System.out.println("Objeto Girafa criado");    
    }

    public void correr() {
        System.out.println("Girafa correndo");
    }

    public void andar() {
        System.out.println("Girafa andando");
    }

    public double calcularVelocidade() {
        return 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public int getQuantidadespatas() {
        return quantidadespatas;
    }

    public void setQuantidadespatas(int quantidadespatas) {
        this.quantidadespatas = quantidadespatas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}

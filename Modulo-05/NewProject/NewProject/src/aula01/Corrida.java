package aula01;

import java.util.List;

public class Corrida {
    private Pista pista;
    private List<Girafa> competidores;
    private byte quantidadeVoltas;

    public Corrida(){
        
    }

    public Corrida(Pista pista, List<Girafa> competidores, byte quantidadeVoltas){
        this.pista = pista;
        this.competidores = competidores;
        this.quantidadeVoltas = quantidadeVoltas;
    }

    public void iniciarCorrida(){

    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public List<Girafa> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(List<Girafa> competidores) {
        this.competidores = competidores;
    }

    public byte getQuantidadeVoltas() {
        return quantidadeVoltas;
    }

    public void setQuantidadeVoltas(byte quantidadeVoltas) {
        this.quantidadeVoltas = quantidadeVoltas;
    }
    
}

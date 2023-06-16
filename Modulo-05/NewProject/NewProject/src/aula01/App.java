package aula01;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

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

        Pista pista1 = new Pista();
        pista1.setNome("Interlagos");
        pista1.setComprimento(2.5f);

        List<Girafa> competidores = new ArrayList<Girafa>();
        competidores.add(melman);
        competidores.add(girafales);
        
        Corrida corrida = new Corrida();
        corrida.setQuantidadeVoltas((byte) 2);
        corrida.setPista(pista1);
        corrida.setCompetidores(competidores);

        corrida.iniciarCorrida();
    }
}

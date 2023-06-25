package Controllers;

import java.util.ArrayList;
import java.util.List;

import Models.Pessoa;

public class PessoaController extends Controller <Pessoa> {

    List <Pessoa> listaObj;

    public PessoaController(){
        this.listaObj = new ArrayList<Pessoa>();
    }

    @Override
    public Pessoa recuperar(int id){
        for(Pessoa obj : this.listaObj){
            if(obj.getId() == id){
                return obj;
            }
        }
        return null;
    }

    @Override
    public void inserir(Pessoa obj){
        this.listaObj.add(obj);
    }

    @Override
    public void atualizar(Pessoa obj){
        for (int i = 0; i < this.listaObj.size(); i++) {
            if (this.listaObj.get(i).getId() == obj.getId()) {
                this.listaObj.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Pessoa obj){
        for(Pessoa p : this.listaObj){
            if(p.getId() == obj.getId()){
                this.listaObj.remove(obj);
            }
        }
    }

    @Override
    public List<Pessoa> pegarLista() {
        return this.listaObj;
    }

    
}

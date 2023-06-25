package dao;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.Funcionario;

public class ListasDados {

    private static ListasDados instancia;

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;


    private ListasDados() {
        listaClientes = new ArrayList<Cliente>();
        listaFuncionarios = new ArrayList<Funcionario>();
    }

    public static ListasDados getInstance() {
        if (instancia == null) {
            instancia = new ListasDados();
        }
        return instancia;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Funcionario> getListaFcuncionarios() {
        return listaFuncionarios;
    }
}

package model;

import java.util.Date;

public class Pessoa {
    
    private String nome;
    private char telefone;
    private Date nascimento;
    private char cpf;
    private char rg;
    private String estadoCivil;
    private String endereco;
    private Date criadoEm;	
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;

    public Pessoa() {
    }


    public Pessoa(String nome, char telefone, char cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public char getTelefone() {
        return telefone;
    }


    public void setTelefone(char telefone) {
        this.telefone = telefone;
    }


    public Date getNascimento() {
        return nascimento;
    }


    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    public char getCpf() {
        return cpf;
    }


    public void setCpf(char cpf) {
        this.cpf = cpf;
    }


    public char getRg() {
        return rg;
    }


    public void setRg(char rg) {
        this.rg = rg;
    }


    public String getEstadoCivil() {
        return estadoCivil;
    }


    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Date getCriadoEm() {
        return criadoEm;
    }


    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }


    public Funcionario getCriadoPor() {
        return criadoPor;
    }


    public void setCriadoPor(Funcionario criadoPor) {
        this.criadoPor = criadoPor;
    }


    public Date getAlteradoEm() {
        return alteradoEm;
    }


    public void setAlteradoEm(Date alteradoEm) {
        this.alteradoEm = alteradoEm;
    }


    public Funcionario getAlteradoPor() {
        return alteradoPor;
    }


    public void setAlteradoPor(Funcionario alteradoPor) {
        this.alteradoPor = alteradoPor;
    }
    
    
}

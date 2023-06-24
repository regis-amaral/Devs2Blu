package model;

import java.util.Date;

public class Funcionario extends Pessoa {
    private String escolaridade;
    private String cargo;
    private String ctps;
    private Date dataAdmissao;
    private Date dataDemissao;
    private boolean disponibilidade;
    private boolean status;
    private Date criadoEm;
    private Funcionario criadoPor;
    private Date alteradoEm;
    private Funcionario alteradoPor;
    
    public Funcionario(String nome, char telefone, char cpf) {
        super(nome, telefone, cpf);
    }

    public Funcionario(String nome, char telefone, char cpf, String escolaridade, String cargo, String ctps, Date dataAdmissao) {
        super(nome, telefone, cpf);
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.ctps = ctps;
        this.dataAdmissao = dataAdmissao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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



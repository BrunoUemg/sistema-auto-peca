/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author serpa
 */
public class ClienteFisico extends Cliente {

    private int idClienteFisico;
    private String cpf;
    private String rg;
    private Date dtaNascimento;

    public ClienteFisico(int idCliente, String nome, String endereco, String bairro, String numero, String cep, String cidade, String telefone, String celular, String email) {
        super(idCliente, nome, endereco, bairro, numero, cep, cidade, telefone, celular, email);
    }

    public ClienteFisico(int idClienteFisico, String cpf, String rg, Date dtaNascimento, int idCliente, String nome, String endereco, String bairro, String numero, String cep, String cidade, String telefone, String celular, String email) {
        super(idCliente, nome, endereco, bairro, numero, cep, cidade, telefone, celular, email);
        this.idClienteFisico = idClienteFisico;
        this.cpf = cpf;
        this.rg = rg;
        this.dtaNascimento = dtaNascimento;
    }

    public int getIdClienteFisico() {
        return idClienteFisico;
    }

    public void setIdClienteFisico(int idClienteFisico) {
        this.idClienteFisico = idClienteFisico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(Date dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }

    public ClienteFisico() {

    }

}

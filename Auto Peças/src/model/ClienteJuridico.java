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
public class ClienteJuridico extends Cliente{
    private int idClienteJuridico;
    private String cnpj;
    private String inscricaoEstadual;
    private Date fundacao;

    public ClienteJuridico(int idCliente, String nome, String endereco, String bairro, String numero, String cep, String cidade, String telefone, String celular, String email) {
        super(idCliente, nome, endereco, bairro, numero, cep, cidade, telefone, celular, email);
    }

    public int getIdClienteJuridico() {
        return idClienteJuridico;
    }

    public void setIdClienteJuridico(int idClienteJuridico) {
        this.idClienteJuridico = idClienteJuridico;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }
    
}

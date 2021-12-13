/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serpa
 */
public class Entrada {
    private int idEntrada;
    private String numNota,chaveNota;
    private double valorNota;
    private Date dataNota,dataCompra;
    private List<ItensProdutos> itensProdutos;

    public Entrada(){
       this.itensProdutos = new ArrayList<>();
    }

    public Entrada(int idEntrada, String numNota, String chaveNota, double valorNota, Date dataNota, Date dataCompra, List<ItensProdutos> itensProdutos) {
        this.idEntrada = idEntrada;
        this.numNota = numNota;
        this.chaveNota = chaveNota;
        this.valorNota = valorNota;
        this.dataNota = dataNota;
        this.dataCompra = dataCompra;
        this.itensProdutos = itensProdutos;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getNumNota() {
        return numNota;
    }

    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    public String getChaveNota() {
        return chaveNota;
    }

    public void setChaveNota(String chaveNota) {
        this.chaveNota = chaveNota;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public Date getDataNota() {
        return dataNota;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<ItensProdutos> getItensProdutos() {
        return itensProdutos;
    }

    public void setItensProdutos(List<ItensProdutos> itensProdutos) {
        this.itensProdutos = itensProdutos;
    }
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serpa
 */
public class Venda {

    private int idVenda, idFunc;
    private Cliente cli;
    private Date dataVenda;
    private double valorTotal;
    private List<ItensVenda> itensVenda;

    public Venda() {
        this.itensVenda = new ArrayList<>();
    }

    public Venda(int idVenda, int idFunc, Cliente cli, Date dataVenda, double valorTotal, List<ItensVenda> itensVenda) {
        this.idVenda = idVenda;
        this.idFunc = idFunc;
        this.cli = cli;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.itensVenda = itensVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItensVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItensVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    
}

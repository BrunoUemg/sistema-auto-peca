/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author serpa
 */
public class ItensProdutos {

    private int idItem;
    private Produto produto;
    private double precoUnitario;
    private int quantidade;
    private Fornecedor fornecedor;

    public ItensProdutos(int idItem, Produto produto, double precoUnitario, int quantidade, Fornecedor fornecedor) {
        this.idItem = idItem;
        this.produto = produto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public ItensProdutos() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    
}

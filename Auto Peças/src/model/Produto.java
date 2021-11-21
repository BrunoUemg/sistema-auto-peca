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
public class Produto {

    private int idProduto;
    private String nome;
    private String descricao;
    private int quantidadeMin;
    private int quantidadeEstoque;
    private float valorCompra;
    private float valorSaida;
    private String codigoBarras;
    private int idCategoria;
    private int idMarca;
    private String nomeCategoria;
    private String nomeMarca;

    public Produto() {
    }

    public Produto(int idProduto, String nome, String descricao, int quantidadeMin, int quantidadeEstoque, float valorCompra, float valorSaida, String codigoBarras, int idCategoria, int idMarca, String nomeCategoria, String nomeMarca) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorCompra = valorCompra;
        this.valorSaida = valorSaida;
        this.codigoBarras = codigoBarras;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.nomeCategoria = nomeCategoria;
        this.nomeMarca = nomeMarca;
    }

    
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(float valorSaida) {
        this.valorSaida = valorSaida;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    

}

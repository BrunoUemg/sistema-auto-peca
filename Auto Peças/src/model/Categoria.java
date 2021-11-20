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
public class Categoria {
    private int idCategoria;
    private String descricaoCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String descricaoCategoria) {
        this.idCategoria = idCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }
    
    
    
}

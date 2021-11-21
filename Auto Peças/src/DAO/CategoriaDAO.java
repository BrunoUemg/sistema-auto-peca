/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author serpa
 */
public class CategoriaDAO {
    PreparedStatement pst;
    String sql;
    int idCategoria;
    
    public List<Categoria> read() throws SQLException {

        sql = "SELECT * from categoria";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = null;

        List<Categoria> categorias = new ArrayList<>();

        try {
            rs = pst.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricaoCategoria(rs.getString("descricaoCategoria"));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }

        return categorias;

    }
    
    public String salvarCategoria(Categoria categoria) throws SQLException {
        sql = "INSERT INTO categoria values(?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, categoria.getDescricaoCategoria());
        int row = pst.executeUpdate();
        pst.close();
        if (row == 1) {
            return "Categoria cadastrada com sucesso!";
        }
        return "Erro ao cadastrar categoria!";
    }
}

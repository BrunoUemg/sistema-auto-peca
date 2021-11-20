/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Produto;

/**
 *
 * @author serpa
 */
public class ProdutoDAO {

    PreparedStatement pst;
    String sql;
    int idProduto;
    int idCategoria;
    int idMarca;

    public String salvarProduto(Produto produto) throws SQLException {
        sql = "INSERT INTO produto values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, produto.getNome());
        pst.setString(3, produto.getDescricao());
        pst.setInt(4, produto.getQuantidadeMin());
        pst.setInt(5, produto.getQuantidadeEstoque());
        pst.setFloat(6, produto.getValorCompra());
        pst.setFloat(7, produto.getValorSaida());
        pst.setInt(8, produto.getCodigoBarras());
        pst.setInt(9, produto.getIdCategoria());
        pst.setInt(10, produto.getIdMarca());
        int row = pst.executeUpdate();
        pst.close();
        if (row == 1) {
            return "Produto Salvo com sucesso!";
        }
        return "Erro ao salvar produto!";
    }

}

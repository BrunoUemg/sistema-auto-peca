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
import model.Marca;

/**
 *
 * @author serpa
 */
public class MarcaDAO {

    PreparedStatement pst;
    String sql;
    int idCategoria;

    public List<Marca> read() throws SQLException {

        sql = "SELECT * from marca";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ResultSet rs = null;

        List<Marca> marcas = new ArrayList<>();

        try {
            rs = pst.executeQuery();

            while (rs.next()) {

                Marca marca = new Marca();

                marca.setIdMarca(rs.getInt("idMarca"));
                marca.setNomeMarca(rs.getString("nomeMarca"));
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }

        return marcas;

    }
    
    public String salvarMarca(Marca marca) throws SQLException {
        sql = "INSERT INTO marca values(?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, marca.getNomeMarca());
        int row = pst.executeUpdate();
        pst.close();
        if (row == 1) {
            return "Marca cadastrada com sucesso!";
        }
        return "Erro ao cadastrar marca!";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ClienteFisico;
import model.ClienteJuridico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author serpa
 */
public class ClienteDAO {

    PreparedStatement pst;
    String sql;

    public void salvarF(ClienteFisico clienteFisico) throws SQLException {
        sql = "INSERT INTO cliente values(?,?,?,?,null)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, clienteFisico.getNome());
        pst.setString(3, clienteFisico.getEndereco());
        pst.setString(4, clienteFisico.getEndereco());
        pst.execute();
        pst.close();
    }
    
    public void salvarJ(ClienteJuridico clienteJuridico) throws SQLException {
        sql = "INSERT INTO cliente values(?,?,?,?,null)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, clienteJuridico.getNome());
        pst.setString(3, clienteJuridico.getEndereco());
        pst.setString(4, clienteJuridico.getEndereco());
        pst.execute();
        pst.close();
    }
}

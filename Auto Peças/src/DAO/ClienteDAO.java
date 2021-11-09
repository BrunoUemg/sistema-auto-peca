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
        sql = "INSERT INTO cliente values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteFisico.getNome());
        pst.setString(3, clienteFisico.getEndereco());
        pst.setString(4, clienteFisico.getBairro());
        pst.setString(5, clienteFisico.getNumero());
        pst.setString(6, clienteFisico.getCep());
        pst.setString(7, clienteFisico.getCidade());
        pst.setString(8, clienteFisico.getTelefone());
        pst.setString(9, clienteFisico.getCelular());
        pst.setString(10, clienteFisico.getEmail());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao adicionar Cliente.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Erro ao criar o cliente, nenhum ID obtido!");
            }
        }
//        pst.execute();
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

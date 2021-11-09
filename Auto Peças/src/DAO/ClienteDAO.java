/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import model.ClienteFisico;
import model.ClienteJuridico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author serpa
 */
public class ClienteDAO {

    PreparedStatement pst;
    String sql;
    int idCliente;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
                idCliente = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao criar o cliente, nenhum ID obtido!");
            }
        }
        sql = "INSERT INTO cliente_fisico values(?,?,?,?,?)";
        System.out.println(clienteFisico.getCpf());
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteFisico.getCpf());
        pst.setString(3, clienteFisico.getRg());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(clienteFisico.getDtaNascimento()));
        pst.setDate(4,date);
        pst.setInt(5, idCliente);
        pst.executeUpdate();
//        pst.execute();
        pst.close();
    }

    public void salvarJ(ClienteJuridico clienteJuridico) throws SQLException {
        sql = "INSERT INTO cliente values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteJuridico.getNome());
        pst.setString(3, clienteJuridico.getEndereco());
        pst.setString(4, clienteJuridico.getBairro());
        pst.setString(5, clienteJuridico.getNumero());
        pst.setString(6, clienteJuridico.getCep());
        pst.setString(7, clienteJuridico.getCidade());
        pst.setString(8, clienteJuridico.getTelefone());
        pst.setString(9, clienteJuridico.getCelular());
        pst.setString(10, clienteJuridico.getEmail());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao adicionar Cliente.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idCliente = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao criar o cliente, nenhum ID obtido!");
            }
        }
        sql = "INSERT INTO cliente_juridico values(?,?,?,?,?)";
        System.out.println(clienteJuridico.getCnpj());
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteJuridico.getCnpj());
        pst.setString(3, clienteJuridico.getInscricaoEstadual());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(clienteJuridico.getFundacao()));
        pst.setDate(4,date);
        pst.setInt(5, idCliente);
        pst.executeUpdate();
//        pst.execute();
        pst.close();
    }
}

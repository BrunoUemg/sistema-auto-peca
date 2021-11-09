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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        pst.setDate(4, date);
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
        pst.setDate(4, date);
        pst.setInt(5, idCliente);
        pst.executeUpdate();
//        pst.execute();
        pst.close();
    }

    public List<ClienteFisico> readF() throws SQLException {
        ResultSet rs = null;
        List<ClienteFisico> clientesFisico = new ArrayList<>();
        try {
            sql = "SELECT * FROM cliente INNER JOIN cliente_fisico ON cliente.idcliente = cliente_fisico.idcliente";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteFisico clienteFisico = new ClienteFisico();
                clienteFisico.setIdCliente(rs.getInt("idcliente"));
                clienteFisico.setNome(rs.getString("nome"));
                clienteFisico.setEndereco(rs.getString("endereco"));
                clienteFisico.setBairro(rs.getString("bairro"));
                clienteFisico.setNumero(rs.getString("numero"));
                clienteFisico.setCep(rs.getString("cep"));
                clienteFisico.setCidade(rs.getString("cidade"));
                clienteFisico.setTelefone(rs.getString("telefone"));
                clienteFisico.setCelular(rs.getString("celular"));
                clienteFisico.setEmail(rs.getString("email"));
                clienteFisico.setIdClienteFisico(rs.getInt("idcliente_fisico"));
                clienteFisico.setCpf(rs.getString("cpf"));
                clienteFisico.setRg(rs.getString("rg"));
                clienteFisico.setDtaNascimento(rs.getDate("dtNascimento"));
                clientesFisico.add(clienteFisico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return clientesFisico;
    }
    
    public List<ClienteJuridico> readJ() throws SQLException {
        ResultSet rs = null;
        List<ClienteJuridico> clientesJuridico = new ArrayList<>();
        try {
            sql = "SELECT * FROM cliente INNER JOIN cliente_juridico ON cliente.idcliente = cliente_juridico.idcliente";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteJuridico clienteJuridico = new ClienteJuridico();
                clienteJuridico.setIdCliente(rs.getInt("idcliente"));
                clienteJuridico.setNome(rs.getString("nome"));
                clienteJuridico.setEndereco(rs.getString("endereco"));
                clienteJuridico.setBairro(rs.getString("bairro"));
                clienteJuridico.setNumero(rs.getString("numero"));
                clienteJuridico.setCep(rs.getString("cep"));
                clienteJuridico.setCidade(rs.getString("cidade"));
                clienteJuridico.setTelefone(rs.getString("telefone"));
                clienteJuridico.setCelular(rs.getString("celular"));
                clienteJuridico.setEmail(rs.getString("email"));
                clienteJuridico.setIdClienteJuridico(rs.getInt("idcliente_juridico"));
                clienteJuridico.setCnpj(rs.getString("cnpj"));
                clienteJuridico.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                clienteJuridico.setFundacao(rs.getDate("fundacao"));
                clientesJuridico.add(clienteJuridico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return clientesJuridico;
    }
}

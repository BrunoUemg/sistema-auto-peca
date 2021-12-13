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
import model.Fornecedor;

/**
 *
 * @author serpa
 */
public class FornecedorDAO {

    PreparedStatement pst;
    String sql;
    int idFornecedor;

    public void salvarFornecedor(Fornecedor fornecedor) throws SQLException {
        sql = "INSERT INTO fornecedor values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, fornecedor.getRazaoSocial());
        pst.setString(3, fornecedor.getNomeFantasia());
        pst.setString(4, fornecedor.getInscricaoEstadual());
        pst.setString(5, fornecedor.getCnpj());
        pst.setString(6, fornecedor.getTelefone());
        pst.setString(7, fornecedor.getCelular());
        pst.setString(8, fornecedor.getEmail());
        pst.setString(9, fornecedor.getEndereco());
        pst.setString(10, fornecedor.getBairro());
        pst.setInt(11, fornecedor.getNumero());
        pst.setString(12, fornecedor.getCep());
        pst.setString(13, fornecedor.getCidade());
        pst.executeUpdate();
        pst.close();
    }

    public List<Fornecedor> readFornecedores() throws SQLException {
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            sql = "SELECT * FROM fornecedor";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdForncedor(rs.getInt("idFornecedor"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setNumero(rs.getInt("numero"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return fornecedores;
    }
    
    public List<Fornecedor> readFornecedoresLike(String nome) throws SQLException {
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            sql = "SELECT * FROM fornecedor WHERE razaoSocial LIKE ?";
            pst = Conexao.getInstance().prepareStatement(sql);
            pst.setString(1, "%"+nome+"%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdForncedor(rs.getInt("idFornecedor"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setNumero(rs.getInt("numero"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return fornecedores;
    }

    public Fornecedor BuscarFornecedor(String codigo) throws SQLException {
        sql = "SELECT * FROM fornecedor WHERE idFornecedor = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Fornecedor forn = null;
        while (rs.next()) {
            forn = new Fornecedor(rs.getInt("idFornecedor"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"), rs.getString("inscricaoEstadual"), rs.getString("cnpj"), rs.getString("telefone"), rs.getString("celular"), rs.getString("email"), rs.getString("endereco"), rs.getString("bairro"), rs.getInt("numero"), rs.getString("cep"), rs.getString("cidade"));
        }
        pst.close();
        return forn;
    }

    public String alterarFornecedor(Fornecedor fornecedor) throws SQLException {
        sql = "update fornecedor set razaoSocial=?, nomeFantasia=?, InscricaoEstadual=?, cnpj=?, telefone=?, celular=?, email=?, endereco=?, bairro=?, numero=?, cep=?, cidade=? where idFornecedor=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, fornecedor.getRazaoSocial());
        pst.setString(2, fornecedor.getNomeFantasia());
        pst.setString(3, fornecedor.getInscricaoEstadual());
        pst.setString(4, fornecedor.getCnpj());
        pst.setString(5, fornecedor.getTelefone());
        pst.setString(6, fornecedor.getCelular());
        pst.setString(7, fornecedor.getEmail());
        pst.setString(8, fornecedor.getEndereco());
        pst.setString(9, fornecedor.getBairro());
        pst.setInt(10, fornecedor.getNumero());
        pst.setString(11, fornecedor.getCep());
        pst.setString(12, fornecedor.getCidade());

        pst.setInt(13, fornecedor.getIdForncedor());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Alterado com sucesso!";
        }
        return "Erro ao alterar!";
    }

    public String excluirFornecedor(Fornecedor fornecedor) throws SQLException {
        sql = "delete from fornecedor where idFornecedor=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, fornecedor.getIdForncedor());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Excluido com sucesso!";
        }
        return "Erro ao excluir!";
    }
}
